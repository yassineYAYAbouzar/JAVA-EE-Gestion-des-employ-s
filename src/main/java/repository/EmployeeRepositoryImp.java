package repository;


import Database.JPAutil;
import Entities.Employee;
import Entities.Role;
import Database.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class EmployeeRepositoryImp implements GenericRepo<Employee, Long> {
    @Override
    public Employee findByEmail(String email) {

        EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            javax.persistence.Query query =  entityManager.createQuery("from Employee u where u.email = :email");
            query.setParameter("email", email);
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
    public Employee findByEmailAndPassword(String email, String password) {
        EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();

            javax.persistence.Query query =  entityManager.createQuery("from Employee u where u.email = :email and u.password = :password");
            query.setParameter("email", email);
            query.setParameter("password", password);
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
    public int changePassword(String email, String password) {
        EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        int queryExueted = 0;
        try {
            transaction.begin();

            javax.persistence.Query query =  entityManager.createQuery("update Employee u set u.password = :password  where u.email = :email");
            query.setParameter("email", email);
            query.setParameter("password", password);
            queryExueted =query.executeUpdate();
            transaction.commit();
            return queryExueted;
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
        }
    }

}