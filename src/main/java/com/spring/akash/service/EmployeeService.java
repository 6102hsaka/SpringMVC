package com.spring.akash.service;

import java.util.List;

import com.spring.akash.model.Department;
import com.spring.akash.model.Employee;

public interface EmployeeService {
	
	public boolean insert(Employee employee);
	public boolean update(Employee employee);
	public boolean delete(String id);
	
	public Employee getEmployeeById(String id);
	public Department getDepartmentById(String id);
	public List<Employee> getAllEmp();
	public List<Department> getAllDept();

}
