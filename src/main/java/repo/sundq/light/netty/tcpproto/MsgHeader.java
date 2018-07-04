package repo.sundq.light.netty.tcpproto;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author sundq
 * @date 2018年7月1日
 *
 */
public class MsgHeader {
	public static int HADER_LENGTH = 6;
	
	public static byte[] HEADER_START_TAG = {'#', 'S', 'T'};
	
	private byte[] header = new byte[3];
	private int cmd;
	private int length;
	
	public MsgHeader() {
		
	}
	
	public MsgHeader(int cmd, int length) {
		this.cmd = (byte)cmd;
		this.length = (short)length;
	}
	
	
	public int getCmd() {
		return cmd;
	}

	public void setCmd(int cmd) {
		this.cmd = cmd;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setHeader(byte[] header) {
		this.header = header;
	}
	
	
	public void encode(ByteBuf dst) {
		dst.writeBytes(HEADER_START_TAG);
		dst.writeByte(cmd);
		dst.writeShort(length);
	}
	
	public void decode(ByteBuf frame) {
		frame.readBytes(header);
		cmd = frame.readByte();
		length = (short) frame.readUnsignedShort();
	}
	
}
