package com.whitehedge.empmanage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whitehedge.empmanage.modal.Employee;
import com.whitehedge.empmanage.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	/************************ API FOR ADDING EMPLOYEES ***************************/
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {

		Employee employee = employeeService.addEmployee(emp);
		logger.info("Employee Saved in DB");
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}

}
