package com.spring.akash.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.akash.dao.EmployeeDaoImpl;
import com.spring.akash.model.Department;
import com.spring.akash.model.Employee;

@Controller
public class MyController {
	
	@RequestMapping(value = "/")
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("employee",new Employee());
		
		List<Department> depts = new ArrayList<Department>();
		depts.add(new Department("D001", "IT"));
		depts.add(new Department("D002", "Finance"));
		depts.add(new Department("D003", "HR"));
		mv.addObject("depts", depts);
		return mv;
	}
	
	
	@RequestMapping(value = "insertUrl",method = RequestMethod.POST)
	public ModelAndView insertEmpPost(@ModelAttribute("employee") Employee emp) {
		System.out.println(emp);
		
		ModelAndView mv = new ModelAndView("home");
		List<Department> depts = new ArrayList<Department>();
		depts.add(new Department("D001", "IT"));
		depts.add(new Department("D002", "Finance"));
		depts.add(new Department("D003", "HR"));
		mv.addObject("depts", depts);
		return mv;
	}
}
