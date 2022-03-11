package gestion.employee.Dae;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public interface GenericDae<T , Long> extends Serializable {
    T insertElement(T t) ;
    T getElementById(String id);
    List<T> selectAllElements();

    boolean deleteElement(String userId);

    T updateElement(T t) ;
}

