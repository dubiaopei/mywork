package cn.dubiaopei.share.synchronize;

public class Thread2 implements Runnable {

	@Override
	public void run() {
		TestThread2 test = new TestThread2();//��֤ÿ�����϶��ǲ�ͬʵ������
		test.execute();
	}
}
