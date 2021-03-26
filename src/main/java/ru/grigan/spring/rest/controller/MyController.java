package ru.grigan.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.grigan.spring.rest.entity.Employee;
import ru.grigan.spring.rest.exception_handling.NoSuchEmployeeException;
import ru.grigan.spring.rest.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/employees")
    public List<Employee> showAllEmployee() {
        return service.getAllEmployee();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        Employee employeeById = service.getEmployeeById(id);
        if (employeeById == null) {
            throw new NoSuchEmployeeException("There is no employee with id = "
                    + id + " in database");
        }
        return employeeById;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return employee;
    }
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employeeById = service.getEmployeeById(id);
        if (employeeById == null) {
            throw new NoSuchEmployeeException("There is no employee with id = "
                    + id + " in database");
        }
        service.deleteEmployee(id);
        return "employee with id = " + id + " was deleted";
    }
}
