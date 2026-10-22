package com.aguzman.java.jdbc.models;

import java.util.Date;

public class Produto {
    private Long id;
    private String nome;
    private Integer preco;
    private Date data_validade;
    private Categoria categoria;

    public Produto() {
    }

    public Produto(Long id, String nome, Integer preco, Date data_validade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.data_validade = data_validade;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public Date getData_validade() {
        return data_validade;
    }

    public void setData_validade(Date dataValidade) {
        this.data_validade = dataValidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return id +
                " | " +
                nome + " | " +
                " | " +
                preco +
                " | " +
                data_validade +
                " | " + categoria.getNome();
    }
}


