package cn.dubiaopei.share.synchronize;

public class Thread4 implements Runnable {
	TestThread4 test = null;


	public Thread4(TestThread4 pTest) { // �������ⲿ���룬������֤��ͬһ������
		test = pTest;
	}

	@Override
	public void run() {
		test.reload();
	}
}
