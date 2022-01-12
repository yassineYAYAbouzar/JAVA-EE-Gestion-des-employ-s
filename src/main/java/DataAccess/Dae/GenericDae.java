package DataAccess.Dae;

import java.io.Serializable;
import java.util.List;

public interface GenericDae<T , Long> extends Serializable {
    T insertEmployee(T t) ;
    T getEmployeeById(long id);
    List<T> selectAllEmployee();
    boolean deleteEmployee(java.lang.Long id);
    T updateEmployee(T t) ;
}

