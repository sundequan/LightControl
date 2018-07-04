package repo.sundq.light.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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

@Component
public class TcpMsgDecoder extends ChannelHandlerAdapter {
	private Logger logger = LoggerFactory.getLogger(TcpMsgDecoder.class);
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		super.exceptionCaught(ctx, cause);
		
	}


	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf frame = (ByteBuf) msg;
		TcpMsg tcpMsg = new TcpMsg();
		MsgHeader msgHeader = new MsgHeader();
		msgHeader.decode(frame);
		tcpMsg.setHeader(msgHeader);
		tcpMsg.setBody(frame.slice(frame.readerIndex(), frame.readableBytes()));
		ctx.fireChannelRead(tcpMsg);
	}

}
