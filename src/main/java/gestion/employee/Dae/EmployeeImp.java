package gestion.employee.Dae;


import gestion.employee.Entities.Employee;
import gestion.employee.Database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeImp implements GenericDae<Employee, Long> {

    @Override
    public Employee insertElement(Employee employee) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
            return employee;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return new Employee();
    }
    @Override
    public Employee getElementById(String userId) {
        Transaction transaction = null;
        Employee employee = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query =  session.createQuery("from Employee u where u.userId = :userId");
            query.setParameter("userId", userId);
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
    public List<Employee> selectAllElements() {

        Transaction transaction = null;
        List<Employee> employeeList=null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

             employeeList = session.createQuery("from Employee",Employee.class).getResultList();

            transaction.commit();
            return  employeeList;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return employeeList;
    }
    @Override
    public boolean deleteElement(String userId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query =  session.createQuery("from Employee u where u.userId = :userId");
            query.setParameter("userId", userId);
            List list = query.list();
            session.remove((list.get(0)));
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public Employee updateElement(Employee employee)  {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(employee);
            transaction.commit();
            return  employee;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return new Employee();
    }
}
