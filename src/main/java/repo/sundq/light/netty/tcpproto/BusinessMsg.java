package repo.sundq.light.netty.tcpproto;

import io.netty.buffer.ByteBuf;

public class BusinessMsg {
	private MsgHeader header;
	private int pkt_no;
	
	private int cmd;
	private ByteBuf data;
	public MsgHeader getHeader() {
		return header;
	}
	public void setHeader(MsgHeader header) {
		this.header = header;
	}
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public ByteBuf getData() {
		return data;
	}
	public void setData(ByteBuf data) {
		this.data = data;
	}
	public int getPkt_no() {
		return pkt_no;
	}
	public void setPkt_no(int pkt_no) {
		this.pkt_no = pkt_no;
	}
	
	
	
	
}
