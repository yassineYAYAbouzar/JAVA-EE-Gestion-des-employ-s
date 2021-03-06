package Dae;

import Entities.Address;

import java.io.Serializable;
import java.util.List;

public interface GenericDae<T , Long> extends Serializable {
    T insertElement(T t) ;
    T getElementById(String id);
    List<T> selectAllElements();
    boolean deleteElement(String userId);
    T updateElement(T t) ;
}

