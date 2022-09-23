package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * @author laishixiong
 * @time 2022/9/23 9:52
 */
public class Service {

	//定义端口
	private final int port = 8080;
	private Server server;
	//服务

	public static void main(String[] args) throws IOException, InterruptedException {
		Service service = new Service();
		service.start();
		service.blockUntilShutdown();
	}


	public void start() throws IOException {
		//开启服务，把grpc需要提供的接口加入
		server = ServerBuilder.forPort(port).addService(new GrpcServerService()).build().start();

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.err.println("------shutting down gRPC server since JVM is shutting down-------");
				Service.this.stop();
				System.err.println("------server shut down------");
			}
		});


	}

	//stop服务
	private void stop() {
		if (server != null) {
			server.shutdown();
		}
	}

	//server阻塞到程序退出
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}


}
