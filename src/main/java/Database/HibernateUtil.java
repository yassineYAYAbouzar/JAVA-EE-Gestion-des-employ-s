package Database;

import Entities.Address;
import Entities.Contact;
import Entities.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.PersistenceUnit;
import java.util.Properties;


@PersistenceUnit(name = "default")
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                //settings.put(Environment.URL, "jdbc:postgresql://localhost:5433/thymleaf");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "root");

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Employee.class);
                configuration.addAnnotatedClass(Address.class);
                configuration.addAnnotatedClass(Contact.class);


                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}