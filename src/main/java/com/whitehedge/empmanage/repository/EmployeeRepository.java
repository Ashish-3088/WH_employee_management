package com.whitehedge.empmanage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whitehedge.empmanage.modal.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
	
	
	List<Employee> findByIsvisible(boolean isvisble);
	
	
}
