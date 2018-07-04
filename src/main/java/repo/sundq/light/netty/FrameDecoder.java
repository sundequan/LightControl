package repo.sundq.light.netty;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import repo.sundq.light.netty.tcpproto.MsgHeader;

public class FrameDecoder extends ByteToMessageDecoder {
	private Logger logger = LoggerFactory.getLogger(FrameDecoder.class);
	private int len_max = 1024;

	public FrameDecoder(int len_max) {
		super();
		this.len_max = len_max;
	}


	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		byte[] tmp_start_tag = { 0, 0, 0 };
		while (in.readableBytes() >= MsgHeader.HADER_LENGTH) {
			in.markReaderIndex();
			in.readBytes(tmp_start_tag);
			if (Arrays.equals(MsgHeader.HEADER_START_TAG, tmp_start_tag)) {
				in.readByte();
				int len = in.readUnsignedShort();
				if (len > len_max) {
					// modify len by finding start_tag
					byte[] in_tmp = new byte[in.readableBytes()];
					in.getBytes(in.readerIndex(), in_tmp);
					int pos = indexOf(in_tmp, tmp_start_tag);
					if(pos != -1) {
						logger.warn("FrameHandler, invalid header length: %d, guessed len: %d, %s\n", len
								, pos, ByteBufUtil.hexDump(in));
						len = pos;
						ByteBuf frame = ctx.alloc().buffer(len + MsgHeader.HADER_LENGTH);
						frame.writeBytes(in, in.resetReaderIndex().readerIndex(), frame.writableBytes());
						out.add(frame);
					} else {
						if(in.readableBytes() + MsgHeader.HADER_LENGTH > len_max) {
							logger.warn("FrameHandler, invalid header length: %d, %s, connect closed\n", len
									, ByteBufUtil.hexDump(in));
							ctx.close();
						} else {
							in.resetReaderIndex();
							return;
						}
					}
				} else if (in.readableBytes() >= len) {
					ByteBuf frame = ctx.alloc().buffer(len + MsgHeader.HADER_LENGTH);
					frame.writeBytes(in, in.resetReaderIndex().readerIndex(), frame.writableBytes());
					out.add(frame);
				} else {
					in.resetReaderIndex();
					return;
				}
			} else {
				logger.warn("FrameHandler, invalid start_tag: %s\n", tmp_start_tag.toString());
			}
		}
	}
	
	private int indexOf(byte[] parent, byte[] child) {
		if(parent == null || child == null) {
			return -1;
		}
		
		if(parent.length < child.length) {
			return -1;
		}
		
		byte[] tmp = new byte[child.length];
		for(int i = 0; i <= parent.length - child.length; i++) {
			System.arraycopy(parent, i, tmp, 0, child.length);
			if(Arrays.equals(tmp, child)) {
				return i;
			}
		}
		return -1;
	}
}
