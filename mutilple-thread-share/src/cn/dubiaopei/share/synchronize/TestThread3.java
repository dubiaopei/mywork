package cn.dubiaopei.share.synchronize;

public class TestThread3 {

	private static Object lock = new Object();

	public synchronized static void execute() { // ͬ����̬����
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}

	public static void execute1() {
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}


	public void test() {
		execute(); // ���������ģ�˵����ͬ����
//		 execute1(); //���������ģ�˵�����첽��
	}
	
}
