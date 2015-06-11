package cn.dubiaopei.share.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
 * һ���̣߳��ȴ���һ���̡߳�
 * 
 */
public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch cdl = new CountDownLatch(1);
		final CountDownLatch cdl2 = new CountDownLatch(3);
		Thread t = new Thread(new Runnable() {// ����

					@Override
					public void run() {

						System.out.println("Ԥ����");
						for (int i = 3; i >= 1; i--) {
							System.out.println(i + "...");
							try {
								TimeUnit.SECONDS.sleep(1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						System.out.println("�ܣ�");
						cdl.countDown(); // ������ ��1
					}
				});
		t.start();
		// t.join();//����

		// System.out.println("main:aaaaa");
		for (int i = 0; i < 3; i++) {// �˶�Ա
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						cdl.await(); // �ȴ���֪����������Ϊ0 Ϊֹ

						System.out.println(Thread.currentThread().getName()
								+ ":������...");

						TimeUnit.SECONDS.sleep(new Random().nextInt(5)+1);
						System.out.println("--��"+Thread.currentThread().getName()
								+ ":�����յ���...");
						
						cdl2.countDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {

				try {
					cdl2.await();
					
					System.out.println("�����ɼ���");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
