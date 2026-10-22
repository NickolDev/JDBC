package com.aguzman.java.jdbc.repository;

import com.aguzman.java.jdbc.models.Produto;
import com.aguzman.java.jdbc.util.ConectionDB;

import java.sql.*;
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
                Produto p = criarProduto(rs);
                produtos.add(p);
            }
        }
        return produtos;
    }

    @Override
    public Produto porId(Long id) {
        Produto produto = null;
        try (PreparedStatement stmt =  getConnection().
                prepareStatement("SELECT * FROM produtos WHERE id =?")){
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    produto = criarProduto(rs);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return produto;
    }

    @Override
    public void guardar(Produto produto) {
        String sql;
        if (produto.getId() != null && produto.getId() > 0) {
           sql = "UPDATE produtos SET nome=?, preco=? WHERE id=?";
        }else{
            sql = "INSERT INTO produtos(nome, preco, data_validade) VALUES(?,?,?)" ;
        }

            try(PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setString(1, produto.getNome());
            stmt.setLong(2, produto.getPreco());

                if (produto.getId() != null && produto.getId() > 0) {
                    stmt.setLong(3, produto.getId());
                }else{
                    stmt.setDate(3, new Date(produto.getData_validade().getTime()));
                }

                stmt.executeUpdate();

        }catch (SQLException throwables){
            throwables.printStackTrace();
        }


    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM produto WHERE id=?")) {
            stmt.setLong(1, id );
            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private static Produto criarProduto(ResultSet rs) throws SQLException {
        Produto p = new Produto();
        p.setId(rs.getLong("id"));
        p.setNome(rs.getString("nome"));
        p.setPreco(rs.getInt("preco"));
        p.setData_validade(rs.getDate("data_validade"));
        return p;
    }
}
