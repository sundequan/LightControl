package repo.sundq.light.netty.tcpproto;

import io.netty.buffer.ByteBuf;

public class HandshakeMsgBodyRep implements MsgBody {
	private int error_code = 0x00;
	
	
	public HandshakeMsgBodyRep(int error_code) {
		this.error_code = error_code;
	}
	
	@Override
	public void encode(ByteBuf dst) {
		// TODO Auto-generated method stub
		dst.writeByte(error_code);
	}

	@Override
	public void decode(ByteBuf src) {
		// TODO Auto-generated method stub

	}

}
