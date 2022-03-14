package gestion.employee.repository;


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
public class EmployeeRepositoryImp implements EmployeeRepository {
    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Employee findByEmail(String email) {

        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("from Employee u where u.email = :email");
        query.setParameter("email", email);
        List list = query.list();
        return (Employee) list.get(0);
    }

    @Override
    public List<Employee> getAllEmployesWithAdresses() {
        return null;
    }

    @Override
    public Employee findByEmailAndPassword(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("from Employee u where u.email = :email and u.password = :password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List list = query.list();
        return (Employee) list.get(0);
    }

    @Override
    public int changePassword(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("update Employee u set u.password = :password  where u.email = :email");
        query.setParameter("email", email);
        query.setParameter("password", password);
        query.executeUpdate();
        return 1;
    }

}