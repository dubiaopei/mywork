package cn.dubiaopei.share.thread;

import java.util.concurrent.TimeUnit;

public class ThreadInfoDemo {
	public static void main(String[] args) {
		
		final Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
//				try {
//					//Thread.sleep(1000*60);
//					TimeUnit.SECONDS.sleep(5);
//					//TimeUnit.MINUTES.sleep(1);
//					
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				
				synchronized (ThreadInfoDemo.class) {
					try {
						ThreadInfoDemo.class.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("hello");
			}
		});
		t.start();
		
		System.out.println(t.getName());
		System.out.println(t.getPriority());//���ȼ�
		System.out.println(t.getState());//�̵߳�״̬ �߳�һ����6��״̬
										//NEW(�½�)  TERMINATED(����) RUNNABLE(��������) BLOCKED(����) 
										// TIMED_WAITING(��ʱ�ȴ�) WAITING(�ȴ�)
		ThreadInfoDemo.class.notify();
	}	
}
