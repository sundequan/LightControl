package repo.sundq.light.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 
 * @author ksun
 * @date 2018年6月3日
 */

@Component
public class TcpServer {
	private Logger logger = LoggerFactory.getLogger(TcpServer.class);
	
	@Value("${tcp.server.port}")
	private int port;

	public void start() {
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();
		ServerBootstrap bootstarp = new ServerBootstrap();
		try {
			bootstarp.group(boss, worker)
			.channel(NioServerSocketChannel.class)
			.option(ChannelOption.SO_BACKLOG, 1024)
			.handler(new LoggingHandler())
			.childHandler(new ServerChannelHandler());
			logger.info("bind port:" +  port);
			ChannelFuture f = bootstarp.bind(port).sync();
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
		
	}
}
