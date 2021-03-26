package ru.grigan.spring.rest.dao;

import ru.grigan.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);

    void deleteEmployee(int id);
}
