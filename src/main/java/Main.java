import Database.JPAutil;
import Entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Main {
    public static void main(String []args){

        
        EntityManager entityManager = JPAutil.entityManagerFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

          //  entityManager.persist();
            transaction.commit();
        }finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
        }
    }
}