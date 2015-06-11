package cn.dubiaopei.share.threadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * ���ν��
 * 
 * ��Ҫÿһ���߳����ҽ���һ������
 */
public class Transformer2 {
	//private static Map<Thread, Transformer2> maps = new HashMap<Thread, Transformer2>();
	
	private static ThreadLocal<Transformer2> maps = new ThreadLocal<Transformer2>();
	private String shape;//��״

	
	private Transformer2(){}
	
	public static Transformer2 getInstance(){
		Transformer2 instance = maps.get();
		if(instance == null){
			instance = new Transformer2();
			maps.set(instance);
			
		}
		return instance;
		
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	
	
}
