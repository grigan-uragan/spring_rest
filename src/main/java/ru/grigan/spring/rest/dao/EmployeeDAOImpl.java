package ru.grigan.spring.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.grigan.spring.rest.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory factory;

    @Override
    public void saveEmployee(Employee employee) {
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        Session session = factory.getCurrentSession();
        return session.createQuery("from Employee", Employee.class).list();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = factory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = factory.getCurrentSession();
        session.createQuery("delete from Employee where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
