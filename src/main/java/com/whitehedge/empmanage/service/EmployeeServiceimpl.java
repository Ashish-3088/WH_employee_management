package com.whitehedge.empmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
		return employeeRepository.findByIsvisible(true);
	}

	@Override
	public Employee getEmployeeById(String id) {
		
		Employee emp = employeeRepository.findById(id).get();
		
		if (emp.isIsvisible() == true) {
			return emp;
		} else {
			return null;
		}
	
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

	@Override
	public String softDeleteEmployee(String id) {
		Employee emp = employeeRepository.findById(id).get();

		if (emp != null) {
			emp.setIsvisible(false);
			employeeRepository.save(emp);
			return "Employee deleted Successfully";
		}

		return "Employee delete failed";
	}

	@Override
	public Page<Employee> getEmployeesPageable(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}

}
