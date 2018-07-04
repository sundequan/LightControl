package repo.sundq.light.netty.tcpproto;

public class MsgCmd {
	public static final byte CMD_HANDSHAKE = 0X00;
	public static final byte CMD_HEARTBEAT = 0X01;
	public static final byte CMD_UP = 0X02;
	public static final byte CMD_DOWN = 0X03;
}
