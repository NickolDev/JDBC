package com.aguzman.java.jdbc;

import com.aguzman.java.jdbc.models.Produto;
import com.aguzman.java.jdbc.repository.ProductRepositoryimpl;
import com.aguzman.java.jdbc.repository.Repository;
import com.aguzman.java.jdbc.util.ConectionDB;

import java.sql.*;

public class ExemploJDBC {
    public static void main(String[] args){
        try (Connection conn = ConectionDB.getInstance()){

            Repository<Produto> repositorio = new ProductRepositoryimpl();
            repositorio.listar().forEach(System.out::println);

            System.out.println(repositorio.porId(1L));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

