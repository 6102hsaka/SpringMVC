package com.spring.akash.dao;

import java.util.List;

import com.spring.akash.model.Employee;

public interface EmployeeDao {

	public boolean insert(Employee employee);
	public boolean update(Employee employee);
	public boolean delete(String id);
	
	public Employee getEmpById(String id);
	public List<Employee> getAllEmp();
}
