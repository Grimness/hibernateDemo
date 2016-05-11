package top.lilianghy.entity;

import java.util.Date;

/**
 * 员工实体类
 * @author Administrator
 *
 */
public class Employee {

	private int empId;
	private String empName;
	private double salary;
	private Date brith;
	
	
	
	public Employee() {
		
	}



	public Employee(int empId, String empName, double salary, Date brith) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.brith = brith;
	}



	



	public int getEmpId() {
		return empId;
	}



	public void setEmpId(int empId) {
		this.empId = empId;
	}



	public String getEmpName() {
		return empName;
	}



	public void setEmpName(String empName) {
		this.empName = empName;
	}



	public double getSalary() {
		return salary;
	}



	public void setSalary(double salary) {
		this.salary = salary;
	}



	public Date getBrith() {
		return brith;
	}



	public void setBrith(Date brith) {
		this.brith = brith;
	}



	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", brith=" + brith + "]";
	}
	
	
	
	
	
}
