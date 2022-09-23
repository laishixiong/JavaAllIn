package client;

import io.grpc.MyResponse;

import java.util.concurrent.CountDownLatch;

/**
 * 处理one2many消息模式
 * 核心问题是怎么确认服务端数据发送完成,需要根据实际业务特殊处理
 *
 * @author laishixiong
 * @time 2022/9/23 14:21
 */
public class ManyExtendResponseObserverImpl implements ExtendResponseObserver {

	String extraStr;

	//模拟只有一条消息返回的情况
	CountDownLatch countDownLatch = new CountDownLatch(5);

	@Override
	public String getExtra() {
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return extraStr;
	}

	private long result;
	private String message;

	@Override
	public void onNext(Object o) {
		//发来一条信息就会触发这里一次
		System.out.println("onNext");
		MyResponse myResponse = (MyResponse) o;
		result = myResponse.getResult();
		message = myResponse.getMessage();
		countDownLatch.countDown();
	}

	@Override
	public void onError(Throwable t) {
		System.out.println("gRPC request error" + t);
		extraStr = "gRPC error, " + t.getMessage();
		countDownLatch.countDown();
	}

	@Override
	public void onCompleted() {
		//服务端发送完成之后，会出发这里面
		System.out.println("on complete");
		extraStr = String.format("总数[%d]，返回信息:%s", result, message);
		System.out.println(extraStr);
		//countDownLatch.countDown();
	}
}
