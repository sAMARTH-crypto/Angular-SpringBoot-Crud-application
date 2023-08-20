package com.demo.controller;
import com.demo.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	//get all employees will return the list of all the employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return empRepo.findAll();
	}
	
	
	//create employee
	@PostMapping("/employees")
	public Employee createEmplyoee(@RequestBody Employee employee) {
		return empRepo.save(employee);
	}
	
	//get employee by id
	@GetMapping("employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable long id) {
		Optional<Employee> employee = empRepo.findById(id);
		return ResponseEntity.ok(employee);
		
	}
	
	
	//update employee - used model class object to access attributes
	@PutMapping("employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Optional<Employee> optionalEmployee = empRepo.findById(id);

        if (optionalEmployee.isPresent()) {
            // If the employee with the given ID exists, get it from the Optional
            Employee employee = optionalEmployee.get();

            // Now update the employee details
            employee.setAge(employeeDetails.getAge());
            employee.setFirstName(employeeDetails.getFirstName());
            employee.setLastName(employeeDetails.getLastName());
            employee.setDesignation(employeeDetails.getDesignation());
            employee.setDepartment(employeeDetails.getDepartment());

            // Save the updated employee back to the repository
            empRepo.save(employee);
	
            return ResponseEntity.ok(employee); // Return the updated employee in the response
        } else {
            // If the employee with the given ID does not exist, return 404 Not Found
            return ResponseEntity.notFound().build();
        }
    }
	
	//delete employee 
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
	    Optional<Employee> employeeOptional = empRepo.findById(id);

	    if (employeeOptional.isPresent()) {
	        Employee employee = employeeOptional.get();
	        empRepo.delete(employee);

	        // Return a success response without using a Map
	        return ResponseEntity.ok().body("Employee with ID " + id + " deleted successfully.");
	    } else {
	        // Return a failure response without using a Map
	        return ResponseEntity.notFound().build();
	    }
	

	}

        
}
