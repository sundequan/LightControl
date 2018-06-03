package repo.sundq.light;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import repo.sundq.light.netty.TcpServer;

@SpringBootApplication
public class LightApplication {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(LightApplication.class, args);
		TcpServer tcpServer = ctx.getBean(TcpServer.class);
		tcpServer.start();
	}
}
