package com.freelancer.controller;


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.freelancer.dto.Employee;

/**
 * @author Jitendra. P. Patil
 *
 */
@SessionAttributes("employeeList")
@Controller
@RequestMapping(value="/EmployeeData")
public class EmployeeController {
 
	@RequestMapping(value = "/GetInitialEmployeeData", method = RequestMethod.GET)
	public ModelAndView getInitialEmployeeData() {
 
		Set<Employee> employeeList = getEmployeeList();
 
		//return back to index.jsp
		ModelAndView model = new ModelAndView("employee");
		model.addObject("employeeList", employeeList);
		model.addObject("employeeInfo", "Table 1.0 Employee Information");
		return model;
 
	}
 
	@RequestMapping(value = "/GetNewEmployeeData", method = RequestMethod.GET)
	public ModelAndView getNewEmployeeData(@ModelAttribute("employeeList") HashSet<Employee> employeeList) {
 
		getEmployeeList(employeeList);
		
		System.out.println(employeeList);
		
		//return back to index.jsp
		ModelAndView model = new ModelAndView("employee");
		model.addObject("employeeList", employeeList);
		model.addObject("employeeInfo", "Table 1.0 Revised Employee Information");
		
		return model;
 
	}
	
	private Set<Employee> getEmployeeList(HashSet<Employee> employeeList) {
		if(employeeList == null || employeeList.size() == 0) {
			return new HashSet<Employee>(); 
		}
		Iterator<Employee> itr = employeeList.iterator();
		while(itr.hasNext()) {
			Employee employee = itr.next();
			employee.setSalary(employee.getSalary() * 1.1);
		}
		return employeeList;
	}

	private Set<Employee> getEmployeeList() {
		Set<Employee> employeeList = new HashSet<Employee>();
		Employee employee = new Employee("Steve", "Jobs", 400000.50);
		employeeList.add(employee);
		employee = new Employee("Bill", "Gates", 200000.50);
		employeeList.add(employee);
		
		return employeeList;
	}
 
}