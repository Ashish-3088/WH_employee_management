package com.whitehedge.empmanage.service;

import org.springframework.stereotype.Service;

import com.whitehedge.empmanage.modal.Employee;

@Service
public interface EmployeeService {

	Employee addEmployee(Employee emp);

}
