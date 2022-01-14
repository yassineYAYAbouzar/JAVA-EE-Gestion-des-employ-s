package Dae;

import java.io.Serializable;
import java.util.List;

public interface GenericDae<T , Long> extends Serializable {
    T insertElement(T t) ;
    T getElementById(long id);
    List<T> selectAllElements();
    boolean deleteElement(Long id);
    T updateElement(T t) ;
}

