package top.lilianghy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * 
 * @author Administrator
 *
 */
public class Hibernateutil {

	/**
	 * 初始化SessionFactory对象
	 */
	private static SessionFactory  sf;
	static{
		sf = new Configuration()
				.configure()
				//.addClass(Employee.class)//通过类名称加载对应的配置文件（不推荐）
				.buildSessionFactory();
	}
	
	public static Session getSession(){
		return sf.openSession();
	}
}
