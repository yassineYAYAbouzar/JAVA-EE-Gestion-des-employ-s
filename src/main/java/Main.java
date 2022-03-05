import gestion.employee.Dae.EmployeeImp;
import gestion.employee.Entities.Employee;

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
