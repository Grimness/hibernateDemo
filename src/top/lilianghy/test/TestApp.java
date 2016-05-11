package top.lilianghy.test;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import top.lilianghy.entity.Employee;

public class TestApp {

	@Test
	public void demoAdd(){
		
		Employee employee = new Employee();
		employee.setEmpName("javac");
		employee.setSalary(250.5);
		employee.setBrith(new Date());
		//创建管理器对象
		Configuration config = new Configuration();
		//加载配置文件  默认加载src/hibernate.cfg.xml
		config.configure();
		//创建sessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory();
		//创建session会话对象
		Session session = sessionFactory.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//执行操作
		session.save(employee);
		//提交事务
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void demofind(){
		//创建管理器对象
		Configuration config = new Configuration();
		//加载配置文件  默认加载src/hibernate.cfg.xml
		config.configure();
		//创建sessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory();
		//创建session会话对象
		Session session = sessionFactory.openSession();
		//开启事务
		session.beginTransaction();
		//执行操作
		Employee emp = (Employee) session.get(Employee.class, 2);
		System.out.println(emp);
		//提交事务
		session.getTransaction().commit();//获取绑定到当前session上的事务
		session.close();
		sessionFactory.close();
		
	}
}
