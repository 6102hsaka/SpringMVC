package com.spring.akash.dao;

import java.util.List;

import com.spring.akash.model.Department;

public interface DepartmentDao {
	
	public Department getDeptById(String id);
	public List<Department> getAllDept();
}
