package repo.sundq.light.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import repo.sundq.light.netty.tcpproto.BusinessMsg;
import repo.sundq.light.netty.tcpproto.BusinessMsgCmd;
import repo.sundq.light.netty.tcpproto.MsgCmd;
import repo.sundq.light.netty.tcpproto.TcpMsg;

public class UpDownMsgHandler extends ChannelHandlerAdapter {
	private Logger logger = LoggerFactory.getLogger(UpDownMsgHandler.class);
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		TcpMsg tcpMsg = (TcpMsg)msg;
		if(tcpMsg.getHeader() != null 
				&& (tcpMsg.getHeader().getCmd() == MsgCmd.CMD_UP
					|| tcpMsg.getHeader().getCmd() == MsgCmd.CMD_DOWN)) {
			BusinessMsg bMsg = new BusinessMsg();
			bMsg.setHeader(tcpMsg.getHeader());
			tcpMsg.getBody().readerIndex(0);
			bMsg.setPkt_no(tcpMsg.getBody().readUnsignedShort());
			bMsg.setCmd(tcpMsg.getBody().readUnsignedShort());
			bMsg.setData(tcpMsg.getBody().slice());
			
			if(bMsg.getCmd() == BusinessMsgCmd.B_CMD_GW_PARAM_WRITE) {
				
			} else {
				logger.info("unknown business cmd: %d, %s", bMsg.getCmd(), msg.toString());
			}
		} else {
			ctx.fireChannelRead(msg);
		}
	}
}
