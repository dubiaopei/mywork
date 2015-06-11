package cn.dubiaopei.share.threadLocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Child implements Runnable{

	private String name;
	private Transformer transformer;
	public Child(String name, Transformer transformer) {
		this.name = name;
		this.transformer = transformer;
	}
	public Child() {
	}
	
	public void play(){
		transformer = Transformer.getInstance();
		synchronized (transformer) {
			
			Random ran = new Random();
			int num = ran.nextInt(100);
			System.out.println(Thread.currentThread().getName() + ":����Ϊ������" + num);
			transformer.setShape("������" + num);
			try {
				TimeUnit.SECONDS.sleep(ran.nextInt(3));
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
