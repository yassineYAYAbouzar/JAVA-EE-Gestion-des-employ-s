package Database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAutil {
   public static EntityManagerFactory entityManagerFactory(){
//jenkins
       EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
       return entityManagerFactory;
   }


}
