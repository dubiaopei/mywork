package cn.dubiaopei.share.threadLocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Child2 implements Runnable {

	private String name;
	private Transformer2 transformer;

	public Child2(String name, Transformer2 transformer) {
		this.name = name;
		this.transformer = transformer;
	}

	public Child2() {
	}

	public void play() {
		// transformer = new Transformer();//ÿһ���涼���´���һ��������Ҫÿһ���߳����ҽ���һ������

		transformer = Transformer2.getInstance();
		System.out
				.println(Thread.currentThread().getName() + ":" + transformer);
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
		System.out.println("-->" + Thread.currentThread().getName() + ":��ȡΪ"
				+ shape);

	}

	@Override
	public void run() {
		play();

	}

}
