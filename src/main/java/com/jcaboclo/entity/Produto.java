package com.jcaboclo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@Getter @Setter
public class Produto extends PanacheEntity {

    private String nome;
    private double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_produto_id")
    private CategoriaProduto categoriaProduto;

}

