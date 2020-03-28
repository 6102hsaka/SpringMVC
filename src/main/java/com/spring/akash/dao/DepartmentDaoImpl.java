package com.spring.akash.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.spring.akash.model.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Department getDeptById(String id) {
		List<Department> departments=null;
		String sql = "SELECT * FROM department WHERE id=?";
		try {
			departments = jdbcTemplate.query(sql, new Object[] {id},(rs,row)->new Department(rs.getString(1), rs.getString(2)));
			return departments.get(0);
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Department> getAllDept() {
		List<Department> departments=null;
		String sql = "SELECT * FROM department";
		try {
			departments = jdbcTemplate.query(sql, (rs,row)->new Department(rs.getString(1), rs.getString(2)));
			return departments;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}