package cn.dubiaopei.share.synchronize;

/**
 * ��ͬʵ��ͬ������
 * @author dubiaopei
 *
 */
public class TestThread2 {

//	public synchronized void execute() { // synchronized
//		for (int i = 0; i < 100; i++) {
//			System.out.println(Thread.currentThread().getName() + ": " + i);
//		}
//	}

	private static Object lock = new Object(); // �����Ǿ�̬�ġ�

	public void execute() {
		synchronized (lock) {// �����˸����������˶���lock����ͬһ����ʵ���У����̰߳�ȫ�ģ�����ͬ��ʵ�����ǲ���ȫ�ġ�
			// ��Ϊ��ͬ��ʵ���в�ͬ������lock
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + ": "+i);
			}
		}
	}
}
