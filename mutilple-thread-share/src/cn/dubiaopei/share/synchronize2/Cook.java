package cn.dubiaopei.share.synchronize2;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Cook implements Runnable{

	private List<Food> foods;
	private static int num = 1;
	public Cook(List<Food> foods) {
		this.foods = foods;
	}
	
	
	public void produce(){
		while(true){
			
			synchronized (foods) {
				if (foods.size() < 10) {
					Food food = new Food(num++);
					foods.add(food);
					System.out.println(Thread.currentThread().getName() + ": "
							+ food.getId() + " �ŷ��Ѿ�������...");
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					foods.notify();//������ѵȴ������е�һ��
//					foods.notifyAll();//���ѵȴ��е������̡߳�
					
				} else {
					System.out.println(Thread.currentThread().getName()
							+ ": ��װ�����Ͻ�����");
					try {
						foods.wait();//��ʦ�ȴ�
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}


	@Override
	public void run() {
		produce();
		
	}
	
}
