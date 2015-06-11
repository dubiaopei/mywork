package cn.dubiaopei.share.lock;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Cook implements Runnable{

	private List<Food> foods;
	private static int num = 1;
	public Cook(List<Food> foods) {
		this.foods = foods;
	}
	
	
	public void produce(){
		while(true){
			
			Lock lock = MyLock.getLock();
			lock.lock();
			Condition cookCon = MyLock.getCookCon();
			Condition windowCon = MyLock.getWindowCon();
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
					
					//foods.notify();//������ѵȴ������е�һ��
					//foods.notifyAll();//���ѵȴ��е������̡߳�
					
					windowCon.signal();//���Ѵ˼������ϰ󶨵�����һ���߳�
					
				} else {
					System.out.println(Thread.currentThread().getName()
							+ ": ��װ�����Ͻ�����");
					try {
						cookCon.await();//��ʦ�ȴ�
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			lock.unlock();
		}
	}


	@Override
	public void run() {
		produce();
		
	}
	
}
