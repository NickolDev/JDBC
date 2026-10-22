package com.aguzman.java.jdbc;

import com.aguzman.java.jdbc.models.Categoria;
import com.aguzman.java.jdbc.models.Produto;
import com.aguzman.java.jdbc.repository.ProductRepositoryimpl;
import com.aguzman.java.jdbc.repository.Repository;
import com.aguzman.java.jdbc.util.ConectionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class ExemploJDBCUpdate {
    public static void main(String[] args){
        try (Connection conn = ConectionDB.getInstance()){

            Repository<Produto> repositorio = new ProductRepositoryimpl();

            System.out.println("============== listar ==============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============== obter por id ==============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============== editar produto ==============");
            Produto produto = new Produto();
            produto.setId(5L);
            produto.setNome("Teclado Razer Mecanico");
            produto.setPreco(700);
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            produto.setCategoria(categoria);
            repositorio.guardar(produto);
            System.out.println("Produto atualizado com exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

