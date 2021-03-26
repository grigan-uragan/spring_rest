package ru.grigan.spring.rest.service;

import ru.grigan.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    void deleteEmployee(int id);
}
