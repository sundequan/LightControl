package repo.sundq.light.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import repo.sundq.light.netty.tcpproto.MsgCmd;
import repo.sundq.light.netty.tcpproto.MsgHeader;
import repo.sundq.light.netty.tcpproto.TcpMsg;

public class HeartBeatHandler extends ChannelHandlerAdapter {
	private Logger logger = LoggerFactory.getLogger(HeartBeatHandler.class);
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		TcpMsg tcpMsg = (TcpMsg)msg;
		if(tcpMsg.getHeader() != null 
				&& tcpMsg.getHeader().getCmd() == MsgCmd.CMD_HEARTBEAT) {
			logger.info("Receive heartbeat： %s\n", msg.toString());
			
			TcpMsg heartbeatRep = createHeartBeatRep();
			ctx.writeAndFlush(heartbeatRep);
		} else {
			ctx.fireChannelRead(msg);
		}
	}

	private TcpMsg createHeartBeatRep() {
		TcpMsg tcpMsg = new TcpMsg();
		MsgHeader msgHeader = new MsgHeader(MsgCmd.CMD_HEARTBEAT, 0);
		tcpMsg.setHeader(msgHeader);
		return tcpMsg;
	}
}
