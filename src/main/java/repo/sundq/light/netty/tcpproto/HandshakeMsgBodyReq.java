package repo.sundq.light.netty.tcpproto;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

public class HandshakeMsgBodyReq implements MsgBody {
	private short hb_interval = 120;
	private String client_id;
	private String username;
	private String passwd;
	private byte client_type;
	private byte business_type;
	private byte net_mode;
	private byte singal_strength;
	
	@Override
	public void encode(ByteBuf dst) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decode(ByteBuf src) {
		// TODO Auto-generated method stub
		hb_interval = src.readUnsignedByte();
		client_id = ByteBufUtil.hexDump(src, src.readerIndex(), 6);
		src.skipBytes(6);
		username = ByteBufUtil.hexDump(src, src.readerIndex(), 8);
		src.skipBytes(8);
		passwd = ByteBufUtil.hexDump(src, src.readerIndex(), 8);
		src.skipBytes(8);
		client_type = src.readByte();
		business_type = src.readByte();
		net_mode = src.readByte();
		singal_strength = src.readByte();
	}

}
