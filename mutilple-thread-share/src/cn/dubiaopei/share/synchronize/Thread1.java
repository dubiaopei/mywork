package cn.dubiaopei.share.synchronize;

public class Thread1 implements Runnable {
	TestThread1 test = null;


	public Thread1(TestThread1 pTest) { // �������ⲿ���룬������֤��ͬһ������
		test = pTest;
	}

	@Override
	public void run() {
		test.execute();
	}
}
