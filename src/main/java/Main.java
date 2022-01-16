import Dae.AddressImp;
import Dae.EmployeeImp;
import Database.HibernateUtil;
import Entities.Address;
import Entities.Employee;
import Entities.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       // Transaction transaction = null;
       // Session session = HibernateUtil.getSessionFactory().openSession();
        //transaction = session.beginTransaction();
        //TypedQuery<Employee> employeeList = session.createQuery("from Employee",Employee.class);
        //transaction.commit();
        EmployeeImp employeeImp = new EmployeeImp();
        List<Employee> selectAllElements= employeeImp.selectAllElements();

        for (int i = 0 ; i <selectAllElements.get(0).getAddresses().size() ; i++){
            System.out.println(selectAllElements.get(0).getAddresses());
        }

    }
}
