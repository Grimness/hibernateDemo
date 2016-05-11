package top.lilianghy.dao;

import java.io.Serializable;
import java.util.List;

import top.lilianghy.entity.Employee;

public interface EmployeeDao {

	/**
	 * 
	 */
	
	/**
	 * 保存员工信息
	 * @param emp
	 */
	void save(Employee emp);
	
	/**
	 * 更新员工信息
	 * @param emp
	 */
	void update(Employee emp);
	
	/**
	 * 根据id删除员工信息
	 * @param emp
	 */
	void delete(Serializable id);
	
	/**
	 * 根据id查询员工信息
	 * @param id
	 * @return
	 */
	Employee findId(Serializable id);

	/**
	 * 查询所有员工的信息
	 * @return
	 */
	List<Employee> findAll();
	
	/**
	 * 分页查询
	 * @param 查询的其实行
	 * @param 需要查询的行数
	 * @return 
	 */
	List<Employee> findPage(int begin,int end);
}
