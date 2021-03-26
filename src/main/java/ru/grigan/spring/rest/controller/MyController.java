package ru.grigan.spring.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
