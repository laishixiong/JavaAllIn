package client;

import io.grpc.*;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.concurrent.TimeUnit;

/**
 * @author laishixiong
 * @time 2022/9/23 9:52
 */
public class Client {

	private static int port = 8080;
	private final ManagedChannel channel;
	private SimpleGrpc.SimpleStub simpleStub;
	private static final String host = "127.0.0.1";

	public static void main(String[] args) {
		Client client = new Client(host, port);
		GrpcClientService grpcClientService = new GrpcClientService();
		grpcClientService.setSimpleStub(client.getSimpleStub());
		//grpcClientService.callOneToOne("One - One");
		//grpcClientService.callOneToMany("one - many");
		grpcClientService.callManyToOne("many-to-one",5);
	}

	public Client(String host, int port) {
		//usePlaintext表示明文传输，否则需要配置ssl
		//channel  表示通信通道
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
		//存根
		simpleStub = SimpleGrpc.newStub(channel);
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

	public SimpleGrpc.SimpleStub getSimpleStub() {
		return simpleStub;
	}
}
