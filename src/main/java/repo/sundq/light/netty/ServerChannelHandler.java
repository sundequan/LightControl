package repo.sundq.light.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.ReadTimeoutHandler;

/**
 * 
 * @author ksun
 * @date 2018年6月3日
 */
public class ServerChannelHandler extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// TODO Auto-generated method stub
		ch.pipeline().addLast(new FrameDecoder(1024));
		ch.pipeline().addLast(new TcpMsgDecoder());
		ch.pipeline().addLast(new BusinessMsgEncoder());
		ch.pipeline().addLast(new TcpMsgEncoder());
		ch.pipeline().addLast("ReadTimeoutHandler", new ReadTimeoutHandler(60));
		ch.pipeline().addLast("HeartBeatHanlder", new HeartBeatHandler());
		ch.pipeline().addLast("HandshakeHandler", new HandShakeHandler());
		ch.pipeline().addLast("UpDownHandler", new UpDownMsgHandler());
	}

}
