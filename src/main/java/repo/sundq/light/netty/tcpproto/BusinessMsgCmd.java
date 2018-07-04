package repo.sundq.light.netty.tcpproto;

public class BusinessMsgCmd {
	public static final int B_CMD_TRANSPARENT = 0X0000;
	public static final int B_CMD_GW_PARAM_WRITE = 0X0001;
	public static final int B_CMD_GW_PARAM_READ = 0X0081;
	public static final int B_CMD_GW_OP = 0X0002;
	public static final int B_CMD_MODULE_SWITCH_WRITE = 0X0003;
	public static final int B_CMD_MODULE_SWITCH_READ = 0X0083;
	
	public static final int B_CMD_MODULE_SWITCH_REPORT = 0X0043;
	public static final int B_CMD_MODULE_NUMBER_REPORT = 0X0023;
	
	public static final int B_CMD_MODULE_ADDR_SYNC = 0X0004;
	public static final int B_CMD_MODULE_ADDR_READ = 0X0084;
	
	public static final int B_CMD_MODULE_PARAM_WRITE = 0X0005;
	
}
