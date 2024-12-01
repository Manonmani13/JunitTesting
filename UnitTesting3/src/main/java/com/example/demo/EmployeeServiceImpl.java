package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
	}
	public void save(Employee employee)
    {
		employeeRepository.save(employee);
    }
	 public Employee getById(Long id)
	    {
	        Optional<Employee> optional = employeeRepository.findById(id);
	        Employee employee = null;
	        if (optional.isPresent())
	            employee = optional.get();
	        else
	            throw new RuntimeException(
	                "Employee not found for id : " + id);
	        return employee;
	    }
	 
	     public void deleteViaId(long id)
	    {
	    	 employeeRepository.deleteById(id);
	    }
}
