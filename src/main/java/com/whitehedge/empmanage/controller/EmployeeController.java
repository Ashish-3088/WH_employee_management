package com.whitehedge.empmanage.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee emp) {

		Employee employee = employeeService.addEmployee(emp);
		logger.info("Employee Saved in DB");
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);

	}
	
	
	/************************ API FOR GETTING EMPLOYEE LIST ***************************/
	@GetMapping("/emplist")
	public ResponseEntity<List<Employee>> getEmployeeList() {

		List<Employee> employeeList = employeeService.getEmployeeList();
		
		if (employeeList != null) {

			logger.info("Employee list fetched");
			return new ResponseEntity<>(employeeList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(employeeList, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	

	/************************ API FOR GETTING EMPLOYEE BY ID ***************************/
	@GetMapping("/empbyid/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {

		Employee employee = employeeService.getEmployeeById(id);
		
		if (employee != null) {

			logger.info("Employee fetched");
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} else {
			logger.info("Employee not found");
			return new ResponseEntity<>(employee, HttpStatus.NO_CONTENT);
		}


	}
	
	
	/************************ API FOR UPDATE EMPLOYEE ***************************/
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee employee) {

		Employee updatedEmp = employeeService.updateEmployee(id, employee);

		logger.info("Employee updated");
		return new ResponseEntity<>(updatedEmp, HttpStatus.OK);

	}
	
	/************************ API FOR DELETE EMPLOYEE ***************************/
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String id) {

		String deleteid = employeeService.deleteEmployee(id);

		logger.info("Employee Deleted");
		return new ResponseEntity<>(deleteid, HttpStatus.OK);

	}
	
	
	/************************ API FOR SOFT DELETE EMPLOYEE ***************************/
	
	@GetMapping("/softdelete/{id}")
	public ResponseEntity<String> softDeleteEmployee(@PathVariable String id) {

		String delete = employeeService.softDeleteEmployee(id);

		
		return new ResponseEntity<>(delete, HttpStatus.OK);

	}
	
	/************************ API FOR GETTING EMPLOYEE LIST BY PAGINATION & SORTING ***************************/
	@GetMapping("/emplistbypageable")
	public ResponseEntity<Page<Employee>> getEmployeesPageable(Pageable pageable) {

		Page<Employee> emppagiable = employeeService.getEmployeesPageable(pageable);

		if (emppagiable != null) {

			logger.info("Employee list fetched");
			return new ResponseEntity<>(emppagiable, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(emppagiable, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	
}
