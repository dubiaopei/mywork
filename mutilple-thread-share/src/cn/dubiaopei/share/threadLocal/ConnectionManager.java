package cn.dubiaopei.share.threadLocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * ThreadLocal ռ�ڴ� -- �ռ任ʱ��
 * �ڴ�й¶��--��WeakReference�������ã�
 * 
 * ��ʹʹ���������ü�����ҲӦ����ʵ�ʿ������ֶ�����remove()�ͷ��ڴ�;
 * 
 */

public class ConnectionManager {
	private static ThreadLocal<Connection> maps = new ThreadLocal<Connection>();
	public Connection getInstance(){
		Connection conn = maps.get();
		if(conn == null) {
			try {
				conn = DriverManager.getConnection("");//��ȡConnection����
				maps.set(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}
