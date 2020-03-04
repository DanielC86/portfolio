package com.daniel.czajka.dao;

import com.daniel.czajka.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO{

    //define fields for entity manager
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findALl() {

        //get current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        //execute the query
        List<Employee> employees = theQuery.getResultList();

        //return results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get the employee by id
        Employee theEmployee = currentSession.get(Employee.class, theId);

        //return the employee
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //save the employee
        currentSession.saveOrUpdate(theEmployee);

    }

    @Override
    public void deleteById(int theId) {

        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //delete object with id (primary key)
        Query theQuery = currentSession.createQuery("delete from Employee where id =:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();

    }
}
