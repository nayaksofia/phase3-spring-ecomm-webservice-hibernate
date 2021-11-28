package com.simplilearn.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.webservice.entity.Employee;
import com.simplilearn.webservice.exception.EmployeeNotFoundException;
import com.simplilearn.webservice.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	//1. Inject dependency
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	//2. Get All Employees
	@GetMapping("/employees")
	public List<Employee>getAllEmployees(){
		
		return this.employeeRepository.findAll();
	}
	
	//3. Get One Employee By ID
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id")long employeeId) {
		return this.employeeRepository.findById(employeeId).orElseThrow(()->{
			throw new EmployeeNotFoundException("Employee Not Found With Id" + employeeId);
		});
	}
	//4. Add Employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	//5. Update Employee
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@RequestBody Employee employee) {
		//5.1 find employee
		Employee fetchedEmp = this.employeeRepository.findById(employee.getId()).orElseThrow(()->{
			throw new EmployeeNotFoundException("Employee Not Found With Id" + employee.getId());
		});
		//5.2 set new employee
		fetchedEmp.setName(employee.getName());
		fetchedEmp.setEmail(employee.getEmail());
        fetchedEmp.setDept(employee.getDept());
        fetchedEmp.setGender(employee.getGender());
        fetchedEmp.setAge(employee.getAge());
        fetchedEmp.setSalary(employee.getSalary());
		//5.3 save employee
        
        return this.employeeRepository.save(fetchedEmp);
	}
	
	//6. Delete Employee By ID
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable(value="id")long empId) {
		//6.1 find employee
		Employee fetchedEmp = this.employeeRepository.findById(empId).orElseThrow(()->{
			throw new EmployeeNotFoundException("Employee Not Found With Id" + empId);
		});
		
		//6.2 Delete employee
		this.employeeRepository.delete(fetchedEmp);
		
	}

}
