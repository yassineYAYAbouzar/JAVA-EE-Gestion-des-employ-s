package gestion.employee.repository;


import gestion.employee.Database.HibernateUtil;
import gestion.employee.Entities.Employee;
import gestion.employee.Entities.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeRepositoryImp implements GenericRepo<Employee, Long> {
    @Override
    public Employee findByEmail(String email) {
        Transaction transaction = null;
        Employee employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query =  session.createQuery("from Employee u where u.email = :email");
            query.setParameter("email", email);
            List list = query.list();
            transaction.commit();
            return (Employee) list.get(0);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployesWithAdresses() {
        return null;
    }

    @Override
    public Employee findByEmailAndPassword(String email, String password) {
        Transaction transaction = null;
        Employee employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query =  session.createQuery("from Employee u where u.email = :email and u.password = :password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            List list = query.list();
            System.out.println(list.get(0));

            transaction.commit();
            return (Employee) list.get(0);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public int changeRole(String email, Role role) {
        Transaction transaction = null;
        int queryExueted = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query =  session.createQuery("update Employee u set u.role = :role  where u.email = :email");
            query.setParameter("email", email);
            query.setParameter("role", role);
            queryExueted = query.executeUpdate();

            transaction.commit();
            return queryExueted;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return queryExueted;
    }

    @Override
    public int changePassword(String email, String password) {
        Transaction transaction = null;
        int queryExueted = 0;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query =  session.createQuery("update Employee u set u.password = :password  where u.email = :email");
            query.setParameter("email", email);
            query.setParameter("password", password);
            queryExueted = query.executeUpdate();

            transaction.commit();
            return queryExueted;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return queryExueted;
    }

}