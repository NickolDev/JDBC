package com.aguzman.java.jdbc;

import com.aguzman.java.jdbc.models.Produto;
import com.aguzman.java.jdbc.repository.ProductRepositoryimpl;
import com.aguzman.java.jdbc.repository.Repository;
import com.aguzman.java.jdbc.util.ConectionDB;

import java.sql.*;
import java.util.Date;

public class ExemploJDBC {
    public static void main(String[] args){
        try (Connection conn = ConectionDB.getInstance()){

            Repository<Produto> repositorio = new ProductRepositoryimpl();

            System.out.println("============== listar ==============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============== obter por id ==============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============== adicionar novo produto ==============");
            Produto produto = new Produto();
                produto.setNome("Teclado Mecanico");
                produto.setPreco(500);
                produto.setData_validade(new Date());
                repositorio.guardar(produto);
            System.out.println("Produto adiconado com exito");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

