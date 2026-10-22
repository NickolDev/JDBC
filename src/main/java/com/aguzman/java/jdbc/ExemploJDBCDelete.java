package com.aguzman.java.jdbc;

import com.aguzman.java.jdbc.models.Produto;
import com.aguzman.java.jdbc.repository.ProductRepositoryimpl;
import com.aguzman.java.jdbc.repository.Repository;
import com.aguzman.java.jdbc.util.ConectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class ExemploJDBCDelete {
    public static void main(String[] args){
        try (Connection conn = ConectionDB.getInstance()){

            Repository<Produto> repositorio = new ProductRepositoryimpl();

            System.out.println("============== listar ==============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============== obter por id ==============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============== deletar produto ==============");

            repositorio.delete(4L);
            System.out.println("Produto deletado com exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

