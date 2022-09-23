package client;

import io.grpc.stub.StreamObserver;

/**
 * 正常情况下我们都是用StreamObserver处理服务端响应，这里由于是异步响应，需要额外的方法从StreamObserver中取出业务数据，于是定一个新接口，
 * 继承自StreamObserver，新增getExtra方法可以返回String对象
 * @author laishixiong
 * @time 2022/9/23 14:07
 */
public interface ExtendResponseObserver<T> extends StreamObserver<T> {
	Object getExtra();
}
