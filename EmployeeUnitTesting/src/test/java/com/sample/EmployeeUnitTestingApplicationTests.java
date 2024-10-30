package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Transactional
public class EmployeeUnitTestingApplicationTests {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    public void setUp() {
        employee = new Employee("John", "Doe", "john.doe@example.com");
    }

    @Test
    public void testSaveEmployee_Success() {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        assertNotNull(savedEmployee.getId());
        assertEquals(employee.getEmail(), savedEmployee.getEmail());
    }

    @Test
    public void testSaveEmployee_AlreadyExists() {
        employeeService.saveEmployee(employee);
        
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            employeeService.saveEmployee(employee);
        });

        assertEquals("Employee already exist with given email:" + employee.getEmail(), exception.getMessage());
    }

    @Test
    public void testGetAllEmployees() {
        employeeService.saveEmployee(employee);
        List<Employee> employees = employeeService.getAllEmployees();
        
        assertNotNull(employees);
        assertEquals(1, employees.size());
        assertEquals(employee.getEmail(), employees.get(0).getEmail());
    }

    @Test
    public void testGetEmployeeById_Success() {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        long id = savedEmployee.getId();
        
        var foundEmployee = employeeService.getEmployeeById(id);
        assertTrue(foundEmployee.isPresent());
        assertEquals(employee.getEmail(), foundEmployee.get().getEmail());
    }

    @Test
    public void testGetEmployeeById_NotFound() {
        var foundEmployee = employeeService.getEmployeeById(1L);
        assertFalse(foundEmployee.isPresent());
    }

    @Test
    public void testUpdateEmployee_Success() {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        long id = savedEmployee.getId();

        employee.setFirstName("Jane");
        Employee updatedEmployee = employeeService.updateEmployee(employee, id);
        
        assertNotNull(updatedEmployee);
        assertEquals("Jane", updatedEmployee.getFirstName());
    }

    @Test
    public void testUpdateEmployee_NotFound() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            employeeService.updateEmployee(employee, 1L);
        });

        assertNotNull(exception);
    }

    @Test
    public void testDeleteEmployee() {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        long id = savedEmployee.getId();

        assertDoesNotThrow(() -> employeeService.deleteEmployee(id));
        assertFalse(employeeService.getEmployeeById(id).isPresent());
    }
}
