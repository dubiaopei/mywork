package cn.dubiaopei.share.concurrent;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangeerDemo {

	public static void main(String[] args) {

		final Exchanger<String>  exchanger = new Exchanger<String>();
		
		for (int i = 0; i < 3; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + "�����ӡ�����");
					try {
						TimeUnit.SECONDS.sleep(new Random().nextInt(5)+1);
						String s1 = "����";
						String s2 = exchanger.exchange(s1);
						System.out.println(Thread.currentThread().getName()+":"+s2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}).start();
		}
		for (int i = 0; i < 3; i++) {

			new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("-->"+Thread.currentThread().getName() + "����ӡ�����");
					try {
						TimeUnit.SECONDS.sleep(new Random().nextInt(5)+1);
						String s1 = "100Ԫ";
						String s2 = exchanger.exchange(s1);
						System.out.println("-->"+Thread.currentThread().getName()+":"+s2);
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
			}).start();
		}


	}
}
