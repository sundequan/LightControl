package repo.sundq.light.netty;

import org.springframework.beans.factory.annotation.Autowired;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 
 * @author ksun
 * @date 2018年6月3日
 */
public class ServerChannelHandler extends ChannelInitializer<SocketChannel> {
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// TODO Auto-generated method stub
		ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(1024, 0, 2));
		ch.pipeline().addLast(new StringDecoder());
		ch.pipeline().addLast(new LightDecoder());
	}

}
