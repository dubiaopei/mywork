package cn.dubiaopei.share.synchronize;

public class Singleton {
	
   private static final class sunSingleton{
	   private static Singleton instance = new Singleton();
	   
	   public static Singleton getInstance(){
		   return instance;
	   }
	   private sunSingleton(){
		   
	   }
   }
   
   private Singleton(){
	   
   }
   
   public static Singleton getInstance(){
	   return sunSingleton.getInstance();
   }
}
