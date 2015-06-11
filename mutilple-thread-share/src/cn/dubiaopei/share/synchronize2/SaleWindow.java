package cn.dubiaopei.share.synchronize2;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SaleWindow implements Runnable {

	private List<Food> foods;

	public SaleWindow(List<Food> foods) {
		this.foods = foods;
	}

	public SaleWindow() {
	}

	public void sale() {

		while (true) {
			synchronized (foods) {
				if (foods.size() > 0) {
					Food food = foods.get(0);
					System.out.println(Thread.currentThread().getName() + ": "
							+ food.getId() + " �ŷ��Ѿ�����ȥ��...");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					foods.remove(0);
					foods.notifyAll();//����
					
				} else {
					System.out.println(Thread.currentThread().getName()
							+ ": ���������Ͻ�����");
					try {
						foods.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	public void run() {
		sale();
	}
}
