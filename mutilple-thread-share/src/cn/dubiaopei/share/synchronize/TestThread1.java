package cn.dubiaopei.share.synchronize;

/**
 * ͬʵ��ͬ������
 * @author dubiaopei
 *
 */
public class TestThread1 {
	
//	public void execute() { // synchronized,δ����
//		for (int i = 0; i < 100; i++) {
//			System.out.println(Thread.currentThread().getName() + ": "+i);
//		}
//	}
	
	public synchronized void execute() { // synchronized
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + ": "+i);
		}
	}
}
