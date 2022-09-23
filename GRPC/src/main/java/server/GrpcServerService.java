package server;

import io.grpc.MyRequest;
import io.grpc.MyResponse;
import io.grpc.ServerServiceDefinition;
import io.grpc.SimpleGrpc;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

/**
 * 服务端提供接口实现
 *
 * @author laishixiong
 * @time 2022/9/23 9:53
 */
public class GrpcServerService extends SimpleGrpc.SimpleImplBase {

	/**
	 * 客户端发一条信息，服务端返回一条
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/23 14:40
	 */
	@Override
	public void oneToOne(MyRequest request, StreamObserver<MyResponse> responseObserver) {
		// request里面定义了两个参数
		System.out.println("客户端传来的参数：" + request.getName() + " " + request.getValue());
		//正式项目下面应该是编写具体的方法业务逻辑了
		//.......
		//创建返回结果数据结构
		MyResponse myResponse = MyResponse.newBuilder().setMessage("单项RPC调用").setResult(11L).build();
		//把数据返回给客户端，向客户端输出数据
		responseObserver.onNext(myResponse);
		//结束本次请求
		responseObserver.onCompleted();
	}

	/*
	 * 客户端发一条信息，服务端返回多条
	 * @author:laishixiong
	 * @time: 2022/9/23 9:54
	 * @description: 客户端
	 * @params:
	 * @return:
	 */
	@Override
	public void oneToMany(MyRequest request, StreamObserver<MyResponse> responseObserver) {
		System.out.println("客户端传来的参数：" + request.getName() + " " + request.getValue());
		long result = 0;
		//返回十条消息给客户端
		for (int i = 1; i <= 10; i++) {
			MyResponse myResponse = MyResponse.newBuilder()
					.setMessage(request.getName() + i)
					.setResult(result += i)
					.build();
			//把数据返回给客户端，向客户端输出数据
			responseObserver.onNext(myResponse);
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//结束本次请求
		responseObserver.onCompleted();
	}

	/**
	 * 客户端发送多条消息，这个方法没有取获取客户端的参数，服务端就返回一条消息
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/23 11:30
	 */
	@Override
	public StreamObserver<MyRequest> manyToOne(StreamObserver<MyResponse> responseObserver) {

		// 返回匿名类，给上层框架使用
		return new StreamObserver<MyRequest>() {

			// 记录总量
			private int totalCount = 0;

			@Override
			public void onNext(MyRequest myRequest) {
				//每次来消息都触发这里
				System.out.println("正在处理:，" + myRequest.getName() + "数量为:" + myRequest.getValue());
				// 增加总量
				totalCount += myRequest.getValue();
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("异常" + t);
			}

			@Override
			public void onCompleted() {
				System.out.println("共计:" + totalCount);
				//给客户端返回处理数据
				responseObserver.onNext(MyResponse.newBuilder()
						.setResult(totalCount)
						.setMessage(String.format("共计[%d]", totalCount))
						.build());
				//结束该次方法调用
				responseObserver.onCompleted();
			}
		};


	}

	/**
	 * 客户端发多条信息，服务端返回多条
	 *
	 * @param
	 * @return
	 * @author laishixiong
	 * @time 2022/9/23 14:40
	 */
	@Override
	public StreamObserver<MyRequest> manyToMany(StreamObserver<MyResponse> responseObserver) {
		// 返回匿名类，给上层框架使用
		return new StreamObserver<MyRequest>() {

			// 记录总量
			private int totalCount = 0;

			@Override
			public void onNext(MyRequest myRequest) {
				System.out.println("正在处理" + myRequest.getName() + "数量为:" + myRequest.getValue());
				// 增加总量
				totalCount += myRequest.getValue();

				Integer value;
				String message;
				if (0 == myRequest.getValue() % 2) {
					value = myRequest.getValue() / 2;
					message = String.format(myRequest.getName() + "的值是2的倍数，减半[%d]成功", value);
				} else {
					value = (myRequest.getValue() + 1) / 2;
					message = String.format(myRequest.getName() + "的值不是2的倍数，减半[%d]成功", value);
				}
				//回复给客户端
				responseObserver.onNext(MyResponse.newBuilder()
						.setResult(value)
						.setMessage(message)
						.build());
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("异常:" + t);
			}

			@Override
			public void onCompleted() {
				//客户端结束发送，服务端也结束发送
				System.out.println("共计:" + totalCount);
				responseObserver.onCompleted();
			}
		};
	}

	@Override
	public ServerServiceDefinition bindService() {
		return super.bindService();
	}
}
