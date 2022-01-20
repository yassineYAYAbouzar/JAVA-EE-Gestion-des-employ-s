package Dae;


import Database.JPAutil;
import Entities.Address;
import Entities.Employee;
import Database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class EmployeeImp implements GenericDae<Employee, Long> {

    @Override
    public Employee insertElement(Employee employee) {
        EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            entityManager.persist(employee);
            transaction.commit();
            return employee;
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
        }
    }
    @Override
    public Employee getElementById(String userId) {
        EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Query query =  entityManager.createQuery("from Employee u where u.userId = :userId");
            query.setParameter("userId", userId);
            transaction.commit();
            return (Employee) query.getResultList().get(0);
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
        }
    }
    @Override
    public List<Employee> selectAllElements() {

        EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        List<Employee> employeeList=null;
        try {
            transaction.begin();

            employeeList = entityManager.createQuery("from Employee",Employee.class).getResultList();
            transaction.commit();
            return  employeeList;
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
        }
    }
    @Override
    public boolean deleteElement(String userId) {

        EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            Query query =  entityManager.createQuery("from Employee u where u.userId = :userId");
            query.setParameter("userId", userId);
            entityManager.remove(query.getResultList().get(0));
            transaction.commit();
            return  true;
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
        }
    }
    @Override
    public Employee updateElement(Employee employee)  {
        EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            entityManager.merge(employee);
            transaction.commit();
            return employee;
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
        }
    }
}
