package com.spring.akash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.akash.dao.DepartmentDaoImpl;
import com.spring.akash.dao.EmployeeDaoImpl;
import com.spring.akash.model.Department;
import com.spring.akash.model.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDaoImpl empDaoImpl;
	@Autowired
	private DepartmentDaoImpl deptDaoImpl;
	
	public void setEmpDaoImpl(EmployeeDaoImpl empDaoImpl) {
		this.empDaoImpl = empDaoImpl;
	}
	
	public void setDeptDaoImpl(DepartmentDaoImpl deptDaoImpl) {
		this.deptDaoImpl = deptDaoImpl;
	}
	
	@Override
	public boolean insert(Employee employee) {
		try {
			return empDaoImpl.insert(employee);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Employee employee) {
		try {
			return empDaoImpl.update(employee);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(String id) {
		try {
			return empDaoImpl.delete(id);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Employee getEmployeeById(String id) {
		return empDaoImpl.getEmpById(id);
	}

	@Override
	public List<Employee> getAllEmp() {
		return empDaoImpl.getAllEmp();
	}

	@Override
	public Department getDepartmentById(String id) {
		return deptDaoImpl.getDeptById(id);
	}
	
	public List<Department> getAllDept() {
		return deptDaoImpl.getAllDept();
	}

}
