package com.aguzman.java.jdbc.repository;

import com.aguzman.java.jdbc.models.Producto;
import com.aguzman.java.jdbc.util.ConectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryimpl implements Repository<Producto> {

    private Connection getConnection() throws SQLException {
        return ConectionDB.getInstance();
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM productos")) {
            while (rs.next()) {
                Producto p = new Producto();
                p.setId(rs.getLong("id"));
                p.setNombre(rs.getString("nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setFechaRegistro(rs.getDate("fecha_registro"));
                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        return null;
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void delete(Long id) {

    }
}
