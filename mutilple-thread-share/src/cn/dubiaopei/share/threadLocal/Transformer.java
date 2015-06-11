package cn.dubiaopei.share.threadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * ���ν��
 * 
 * ��Ҫÿһ���߳����ҽ���һ������
 */
public class Transformer {
	private static Map<Thread, Transformer> maps = new HashMap<Thread, Transformer>();
	private String shape;//��״

	
	private Transformer(){}
	
	public static Transformer getInstance(){
		Transformer instance = maps.get(Thread.currentThread());
		if(instance == null){
			instance = new Transformer();
			maps.put(Thread.currentThread(), instance);
			
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
