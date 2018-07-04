package repo.sundq.light.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import repo.sundq.light.netty.tcpproto.HandshakeMsgBodyRep;
import repo.sundq.light.netty.tcpproto.HandshakeMsgBodyReq;
import repo.sundq.light.netty.tcpproto.MsgBody;
import repo.sundq.light.netty.tcpproto.MsgCmd;
import repo.sundq.light.netty.tcpproto.MsgHeader;
import repo.sundq.light.netty.tcpproto.TcpMsg;

public class HandShakeHandler extends ChannelHandlerAdapter {
	private boolean is_auth = false;
	
	

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		is_auth = false;
		super.exceptionCaught(ctx, cause);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		is_auth = false;
		super.channelInactive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		TcpMsg tcpMsg = (TcpMsg)msg;
		if(tcpMsg.getHeader() != null 
				&& tcpMsg.getHeader().getCmd() == MsgCmd.CMD_HANDSHAKE) {
			MsgBody msgBody = new HandshakeMsgBodyReq();
			msgBody.decode(tcpMsg.getBody());
			
			is_auth = true;
			
			// send handshake back
			TcpMsg handshakeRep = createHandshakeRep();
			ctx.writeAndFlush(handshakeRep);
		} else if(is_auth) {
			ctx.fireChannelRead(msg);
		}
	}
	
	private TcpMsg createHandshakeRep() {
		ByteBuf body = Unpooled.buffer();
		MsgHeader header = new MsgHeader(MsgCmd.CMD_HANDSHAKE, 1);
		MsgBody repBody = new HandshakeMsgBodyRep(0x00);
		repBody.encode(body);
		TcpMsg tcpMsg = new TcpMsg();
		tcpMsg.setHeader(header);
		tcpMsg.setBody(body);
		return tcpMsg;
	}
			
}
