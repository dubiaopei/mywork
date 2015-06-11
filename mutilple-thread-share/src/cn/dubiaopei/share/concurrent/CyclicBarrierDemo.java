package cn.dubiaopei.share.concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/*
 * һ���߳��໥�ȴ���ֱ�����һ���߳�ִ����ĳһ�׶���������ǲŻ�һ������ִ�С�
 * 
 */
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		final CyclicBarrier cb = new CyclicBarrier(3);
		System.out.println("����...");
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						TimeUnit.SECONDS.sleep(new Random().nextInt(5)+1);
						System.out.println(Thread.currentThread().getName()+":����ɽ���ˡ�����");
						cb.await();
						System.out.println();
						TimeUnit.SECONDS.sleep(new Random().nextInt(5)+1);
						System.out.println(Thread.currentThread().getName()+":���극�ˡ�����");
						cb.await();
						System.out.println();
						TimeUnit.SECONDS.sleep(new Random().nextInt(5)+1);
						System.out.println(Thread.currentThread().getName()+":������ˡ�����");
						cb.await();
						System.out.println("�ؼ�");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
}
