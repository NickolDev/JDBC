package com.aguzman.java.jdbc.repository;

import com.aguzman.java.jdbc.models.Produto;
import com.aguzman.java.jdbc.util.ConectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryimpl implements Repository<Produto> {

    private Connection getConnection() throws SQLException {
        return ConectionDB.getInstance();
    }

    @Override
    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM produtos")) {
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getInt("preco"));
                p.setData_validade(rs.getDate("data_validade"));
                produtos.add(p);
            }
        }
        return produtos;
    }

    @Override
    public Produto porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Produto produto) {

    }

    @Override
    public void delete(Long id) {

    }
}
