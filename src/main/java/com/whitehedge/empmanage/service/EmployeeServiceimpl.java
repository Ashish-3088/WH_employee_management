package com.whitehedge.empmanage.service;

import java.util.List;

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

	@Override
	public List<Employee> getEmployeeList() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(String id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee updateEmployee(String id , Employee employee) {
		
		Employee emp = employeeRepository.findById(id).get();
		
		if (emp != null) {
			emp.setAge(employee.getAge());
			emp.setCity(employee.getCity());
			emp.setName(employee.getName());
			return employeeRepository.save(emp);
		}
		
		return employeeRepository.save(emp);
	}

	@Override
	public String deleteEmployee(String id) {
		employeeRepository.deleteById(id);
		return id;
	}

}
