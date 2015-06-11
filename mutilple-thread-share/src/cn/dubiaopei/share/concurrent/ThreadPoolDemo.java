package cn.dubiaopei.share.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		
		ExecutorService pool1 = Executors.newCachedThreadPool();//�����̳߳ء�������
		for (int i = 0; i < 10; i++) {
			pool1.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});
		}
		int num = Runtime.getRuntime().availableProcessors();//��õ�ǰ������м���CPU
		
		System.out.println(num);
		
		ExecutorService pool2 = Executors.newFixedThreadPool(3);//�̶���С���̳߳�
		for (int i = 0; i < 10; i++) {
			pool2.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});
		}
		
		
		ExecutorService pool3 = Executors.newSingleThreadExecutor();//��һ�̳߳�
		for (int i = 0; i < 10; i++) {
			final int j = i;
			pool3.execute(new Runnable() {

				@Override
				public void run() {
					int c;
					if (j == 3)
						c = 3/0;
					System.out.println(Thread.currentThread().getName()+":"+j);
				}
			});
		}
	}
}
