package client;

import io.grpc.MyRequest;
import io.grpc.SimpleGrpc;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 客户端请求服务端的方法
 *
 * @author laishixiong
 * @time 2022/9/23 10:01
 */

public class GrpcClientService {

	private SimpleGrpc.SimpleStub simpleStub;

	public void setSimpleStub(SimpleGrpc.SimpleStub simpleStub) {
		this.simpleStub = simpleStub;
	}

	/**
	 * 客户端调用服务器的OneToOne方法
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/23 10:04
	 */
	public String callOneToOne(String name) {
		//创建请求参数对象
		MyRequest request = MyRequest.newBuilder().setName(name).build();
		OneResponseObserverImpl one2OneResponseObserver = new OneResponseObserverImpl();
		this.simpleStub.oneToOne(request, one2OneResponseObserver);
		System.out.println(one2OneResponseObserver.getExtra());
		return "";
	}

	/**
	 * 客户端调用服务器的oneToMany方法
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/23 10:04
	 */
	public List<String> callOneToMany(String name) {
		MyRequest request = MyRequest.newBuilder().setName(name).build();
		ManyExtendResponseObserverImpl one2ManyExtendResponseObserver = new ManyExtendResponseObserverImpl();
		simpleStub.oneToMany(request, one2ManyExtendResponseObserver);
		System.out.println(one2ManyExtendResponseObserver.getExtra());
		return null;
	}

	public void callManyToOne(String name, Integer value) {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		// responseObserver的onNext和onCompleted会在另一个线程中被执行，
		// ExtendResponseObserver继承自StreamObserver
		//simpleStub.manyToOne
		OneResponseObserverImpl one2OneResponseObserver = new OneResponseObserverImpl();
		//拿到requset对象
		StreamObserver<MyRequest> requestObserver = simpleStub.manyToOne(one2OneResponseObserver);
		for (int i = 0; i < value; i++) {
			MyRequest manyToOne = MyRequest.newBuilder().setName("many to one").setValue(i).build();
			requestObserver.onNext(manyToOne);
		}
		requestObserver.onCompleted();
		one2OneResponseObserver.getExtra();
	}

	public void callManyToMany(String name, Integer value) {
		ManyExtendResponseObserverImpl manyExtendResponseObserver = new ManyExtendResponseObserverImpl();
		StreamObserver requestObserver = simpleStub.manyToMany(manyExtendResponseObserver);
		for (int i = 0; i < value; i++) {
			MyRequest manyToOne = MyRequest.newBuilder().setName("many to one").setValue(i).build();
			requestObserver.onNext(manyToOne);
		}
		requestObserver.onCompleted();
		manyExtendResponseObserver.getExtra();
	}
}
