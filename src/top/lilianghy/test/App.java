package top.lilianghy.test;



import java.util.Date;
import java.util.List;

import org.junit.Test;

import top.lilianghy.dao.EmployeeDao;
import top.lilianghy.dao.impl.EmployeeDaoImpl;
import top.lilianghy.entity.Employee;

public class App {

	EmployeeDao dao = new EmployeeDaoImpl();
	
	@Test
	public void save() {
		dao.save(new Employee());
	}
	@Test
	public void delete() {
		dao.delete(2);
	}
	@Test
	public void update() {
		Employee emp = new Employee();
		emp.setEmpId(11);
		emp.setEmpName("叶二狗子");
		emp.setSalary(111.3);
		emp.setBrith(new Date());
		dao.update(emp);
	}
	@Test
	public void findId() {
		Employee emp = dao.findId(10);
		System.out.println(emp);
	}
	@Test
	public void findAll() {
		List<Employee> list = dao.findAll();
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}
	@Test
	public void findPage() {
		List<Employee> list = dao.findPage(5, 8);
		for (Employee employee : list) {
			System.out.println(employee);
		}
	}

}
