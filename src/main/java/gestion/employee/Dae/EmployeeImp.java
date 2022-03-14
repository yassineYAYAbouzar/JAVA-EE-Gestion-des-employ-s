package gestion.employee.Dae;


import gestion.employee.Entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeImp implements EmployeeDae {

    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Employee insertElement(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(employee);
        return  employee;
    }
    @Override
    public Employee getElementById(String userId) {

        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("from Employee u where u.userId = :userId");
        query.setParameter("userId", userId);
        List list = query.list();
        return (Employee) list.get(0);
    }
    @Override
    public List<Employee> selectAllElements() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee",Employee.class).getResultList();
    }
    @Override
    public boolean deleteElement(String userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("from Employee u where u.userId = :userId");
        query.setParameter("userId", userId);
        List list = query.list();
        session.remove((list.get(0)));
        return true;
    }
    @Override
    public Employee updateElement(Employee employee)  {
        Session session = sessionFactory.getCurrentSession();
         session.merge(employee);
         return employee;
    }
}