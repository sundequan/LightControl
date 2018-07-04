package repo.sundq.light.netty;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import repo.sundq.light.netty.tcpproto.BusinessMsg;
import repo.sundq.light.netty.tcpproto.TcpMsg;

public class BusinessMsgEncoder extends MessageToMessageEncoder<BusinessMsg> {

	@Override
	protected void encode(ChannelHandlerContext ctx, BusinessMsg msg, List<Object> out) throws Exception {
		// TODO Auto-generated method stub
		TcpMsg tcpMsg = new TcpMsg();
		tcpMsg.setHeader(msg.getHeader());
		ByteBuf body = Unpooled.buffer();
		body.writeShort(msg.getPkt_no());
		body.writeShort(msg.getCmd());
		body.writeBytes(msg.getData());
		tcpMsg.setBody(body);
		out.add(tcpMsg);
	}

}
