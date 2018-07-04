package repo.sundq.light.netty;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import repo.sundq.light.netty.tcpproto.MsgHeader;
import repo.sundq.light.netty.tcpproto.TcpMsg;

public class TcpMsgEncoder extends MessageToMessageEncoder<TcpMsg> {

	@Override
	protected void encode(ChannelHandlerContext ctx, TcpMsg msg, List<Object> out) throws Exception {
		// TODO Auto-generated method stub
		ByteBuf sendbuf = Unpooled.buffer();
		
		if(msg != null) {
			if(msg.getBody() != null) {
				msg.getBody().readerIndex(0);
				msg.getHeader().setLength(msg.getBody().readableBytes());
			} else {
				msg.getHeader().setLength(0);
			}
			sendbuf.writeBytes(MsgHeader.HEADER_START_TAG);
			sendbuf.writeByte(msg.getHeader().getCmd());
			sendbuf.writeShort(msg.getHeader().getLength());
			if(msg.getHeader().getLength() > 0) {
				sendbuf.writeBytes(msg.getBody());
			}
			out.add(sendbuf);
		}
	}

	
}
