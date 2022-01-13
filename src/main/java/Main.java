import DataAccess.Dae.EmployeeImp;
import DataAccess.Entities.Employee;
import DataAccess.Role;
import DataAccess.repository.EmployeeRepositoryImp;


public class Main {
    public static void main(String[] args) {

        EmployeeRepositoryImp employeeRepositoryImp = new EmployeeRepositoryImp();

        try {
            employeeRepositoryImp.findByEmailAndPassword("yassinebouzar@gmail.com","passkword");
        }catch (Exception e){
            System.out.println("dddd");
        }
    }
}
