package cn.dubiaopei.share.synchronize;

public class Thread3 implements Runnable {
	TestThread3 test = null;


	public Thread3(TestThread3 pTest) { // �������ⲿ���룬������֤��ͬһ������
		test = pTest;
	}

	@Override
	public void run() {
		test.test();
	}
}
