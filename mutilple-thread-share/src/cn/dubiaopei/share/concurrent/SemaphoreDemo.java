package cn.dubiaopei.share.concurrent;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {

	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(3);//�ź���������� ����̶��������߳� ͬʱ���ʹ�����Դ
		for (int i = 0; i < 10; i++) {

			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						semaphore.acquire();// ������

						System.out.println(Thread.currentThread().getName()
								+ ": ����...������"+(3-semaphore.availablePermits())+"λ�˿�");

						TimeUnit.SECONDS.sleep(new Random().nextInt(5));
						System.out.println("-->"+Thread.currentThread().getName()
								+ ": ����...");

						semaphore.release();// �ͷ����
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}).start();
		}
	}
}
