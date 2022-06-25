package com.whitehedge.empmanage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whitehedge.empmanage.modal.Employee;
import com.whitehedge.empmanage.repository.EmployeeRepository;

@Service
public class EmployeeServiceimpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

}
