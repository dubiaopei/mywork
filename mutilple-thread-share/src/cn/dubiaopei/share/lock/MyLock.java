package cn.dubiaopei.share.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyLock {

	private static Lock lock;
	private static Condition cookCon;
	private static Condition windowCon;

	public synchronized static Lock getLock() {
		if (lock == null)
			lock = new ReentrantLock();
		//lock = new ReentrantLock(true);//��ƽ���� -->˭�ȴ�ʱ���������˭��ȡ����
		return lock;
	}

	public synchronized static Condition getCookCon() {
		if (cookCon == null)
			cookCon = lock.newCondition();
		return cookCon;
	}

	public synchronized static Condition getWindowCon() {//MyLock.class  this
		if (windowCon == null)
			windowCon = lock.newCondition();

		return windowCon;
	}

}
