package repo.sundq.light.netty.tcpproto;

import io.netty.buffer.ByteBuf;

public class TcpMsg {
	private MsgHeader header;
	private ByteBuf body;
	
	public TcpMsg() {
	}
	
	public MsgHeader getHeader() {
		return header;
	}
	public void setHeader(MsgHeader header) {
		this.header = header;
	}

	public ByteBuf getBody() {
		return body;
	}

	public void setBody(ByteBuf body) {
		this.body = body;
	}
	
}
