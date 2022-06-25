package com.whitehedge.empmanage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.whitehedge.empmanage.modal.Employee;

@Service
public interface EmployeeService {

	Employee addEmployee(Employee emp);

	List<Employee> getEmployeeList();

	Employee getEmployeeById(String id);

	Employee updateEmployee(String id, Employee employee);

	String deleteEmployee(String id);

}
