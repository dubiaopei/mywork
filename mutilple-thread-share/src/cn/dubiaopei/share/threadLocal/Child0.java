package cn.dubiaopei.share.threadLocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Child0 implements Runnable{

	private String name;
	private Transformer0 transformer;
	public Child0(String name, Transformer0 transformer) {
		this.name = name;
		this.transformer = transformer;
	}
	public Child0() {
	}
	
	public void play(){
		
		synchronized (transformer) {
			
			Random ran = new Random();
			int num = ran.nextInt(100);
			System.out.println(Thread.currentThread().getName() + ":����Ϊ������" + num);
			transformer.setShape("������" + num);
			try {
				TimeUnit.SECONDS.sleep(ran.nextInt(5));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String shape = transformer.getShape();
			System.out.println(Thread.currentThread().getName() +":��ȡΪ"+ shape);
		}
	}
	
	@Override
	public void run() {
		play();
	}
}
