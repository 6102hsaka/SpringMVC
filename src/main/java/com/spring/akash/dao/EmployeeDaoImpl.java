package com.spring.akash.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.akash.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public boolean insert(Employee employee) {
		String sql = "INSERT INTO employee VALUES(?,?,?,?)";
		try {
			int res = jdbcTemplate.update(sql,employee.getId(),employee.getName(),employee.getSalary(),employee.getDepartmentId());
			return (res==1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Employee employee) {
		String sql = "UPDATE employee SET name=?,salary=?,deptId=? WHERE id=?";
		try {
			int res = jdbcTemplate.update(sql,employee.getName(),employee.getSalary(),employee.getDepartmentId(),employee.getId());
			return (res==1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(String id) {
		String sql = "DELETE FROM employee WHERE id=?";
		try {
			int res = jdbcTemplate.update(sql,id);
			return (res==1);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public Employee getEmpById(String id) {
		List<Employee> employees = null;
		String sql = "SELECT * FROM employee WHERE id = ?";
		try {
			employees = jdbcTemplate.query(sql, new Object[] {id},
					(rs,rowNum)->new Employee(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
					return employees.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> employees = null;
		String sql = "SELECT * FROM employee";
		try {
			employees = jdbcTemplate.query(sql,
					(rs,rowNum)->new Employee(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getString(4)));
					return employees;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
