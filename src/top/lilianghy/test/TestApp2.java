package top.lilianghy.test;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import top.lilianghy.entity.Employee;

public class TestApp2 {
	
	private static SessionFactory  sf;
	static{
		sf = new Configuration()
				.configure()
				//.addClass(Employee.class)//通过类名称加载对应的配置文件（不推荐）
				.buildSessionFactory();
	}
	

	@Test
	public void demoAdd(){
		
		Employee employee = new Employee();
		employee.setEmpName("javac");
		employee.setSalary(250.5);
		employee.setBrith(new Date());
		/*//创建管理器对象
		Configuration config = new Configuration();
		//加载配置文件  默认加载src/hibernate.cfg.xml
		config.configure();
		//创建sessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory();
		*/
		//创建session会话对象
		Session session = sf.openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//执行操作
		session.save(employee);
		//提交事务
		transaction.commit();
		session.close();
		
	}
	
	@Test
	public void demofind(){
		/*//创建管理器对象
		Configuration config = new Configuration();
		//加载配置文件  默认加载src/hibernate.cfg.xml
		config.configure();
		//创建sessionFactory对象
		SessionFactory sessionFactory = config.buildSessionFactory();
		//创建session会话对象
*/	
		Session session = sf.openSession();
		//开启事务
		session.beginTransaction();
		//执行操作
		Employee emp = (Employee) session.get(Employee.class, 4);
		System.out.println(emp);
		//提交事务
		session.getTransaction().commit();//获取绑定到当前session上的事务
		session.close();
		
	}
	
	@Test
	public void Demo(){
		Session session = sf.openSession();
		session.beginTransaction();
		//session.save(new Employee());
		//Employee emp = new Employee();
		//emp.setEmpId(6);
//		emp.setEmpName("天明");
		//session.update(emp);
		//session.saveOrUpdate(emp);
		//session.delete(emp);
		//Object obj = session.get(Employee.class, 1232);  id不存在也去查
		Object object = session.load(Employee.class, 8); //懒加载~~
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	@Test
	public void HQL(){
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select e.empName from Employee as e where e.empId=3 or e.empId=4");
		List list = query.list();
		System.out.println(list);
		
		session.getTransaction().commit();
		session.close();
	}
}
