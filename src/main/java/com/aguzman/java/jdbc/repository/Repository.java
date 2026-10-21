package com.aguzman.java.jdbc.repository;

import java.sql.SQLException;
import java.util.List;

public interface  Repository <T>{
    List<T> listar() throws SQLException;
    T porId(Long id);

    void guardar(T t);

    void delete(Long id);


}
