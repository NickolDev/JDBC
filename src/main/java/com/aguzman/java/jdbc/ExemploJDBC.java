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
            repositorio.listar().forEach(p -> System.out.println(p.getNome()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

