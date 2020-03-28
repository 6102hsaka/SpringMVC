package com.spring.akash.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.akash.dao.EmployeeDaoImpl;
import com.spring.akash.model.Department;
import com.spring.akash.model.Employee;
import com.spring.akash.service.EmployeeServiceImpl;

@Controller
public class MyController {
	
	@Autowired
	private EmployeeServiceImpl serviceImpl;
	
	public void setServiceImpl(EmployeeServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
	}
	
	@RequestMapping(value = "/")
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("employee",new Employee());
		
		List<Department> departments = serviceImpl.getAllDept();
		List<Employee> employees = serviceImpl.getAllEmp();
		
		mv.addObject("emps", employees);
		mv.addObject("depts", departments);
		return mv;
	}
	
	
	@RequestMapping(value = "insertUrl",method = RequestMethod.POST)
	public String insertEmp(@ModelAttribute("employee") Employee employee) {
		System.out.println("Inside Insert Method");
		System.out.println(employee);
		serviceImpl.insert(employee);
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "updateUrl",method = RequestMethod.POST)
	public String updateEmp(@ModelAttribute("employee") Employee employee) {
		System.out.println("Inside Update Method");
		System.out.println(employee);
		serviceImpl.update(employee);
		return "redirect:/";
	}
	
	@RequestMapping(value = "deleteUrl",method = RequestMethod.GET) 
	public String deleteEmp(@RequestParam String id) {
		System.out.println("Inside Delete Method");
		System.out.println(id);
		serviceImpl.delete(id);
		return "redirect:/";
		
	}
}
