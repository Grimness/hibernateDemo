package top.lilianghy.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import top.lilianghy.dao.EmployeeDao;
import top.lilianghy.entity.Employee;
import top.lilianghy.utils.Hibernateutil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void save(Employee emp) {
		Session session = null;
		try {
			session = Hibernateutil.getSession();
			session.beginTransaction();
			session.save(emp);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}

	@Override
	public void update(Employee emp) {
		Session session = null;
		try {
			session = Hibernateutil.getSession();
			session.beginTransaction();
			session.update(emp);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}

	}

	@Override
	public void delete(Serializable id) {
		Session session = null;
		Transaction transaction  = null;
			try {
				session = Hibernateutil.getSession();
				transaction = session.beginTransaction();
				Employee emp = (Employee) session.get(Employee.class, id);
				if(emp != null){
					
					session.delete(emp);
				}
				
				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();//删除不成功事务回滚
				throw new RuntimeException(e);
			}finally{
				session.close();
			}
			

	}

	@Override
	public Employee findId(Serializable id) {
		Session session = null;
		try {
			session = Hibernateutil.getSession();
			session.beginTransaction();
			Employee emp = (Employee) session.get(Employee.class, id);
			session.getTransaction().commit();
			return emp;
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}

	@Override
	public List<Employee> findAll() {
		Session session = null;
		
		try {
			session = Hibernateutil.getSession();
			Query query = session.createQuery("FROM Employee");
			return query.list();
		} catch (HibernateException e) {
			
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	
	}

	@Override
	public List<Employee> findPage(int begin, int end) {
		Session session = null;
		try {
			session = Hibernateutil.getSession();
			Query query = session.createQuery("FROM Employee");
			query.setFirstResult(begin);
			query.setMaxResults(end);
			List<Employee> list = query.list();
			return list;
		} catch (HibernateException e) {
			throw new RuntimeException(e);
		}finally{
			session.close();
		}
	}

}
