package com.simplilearn.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.webservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	//It's An Interface For CRUD Operation 
}
