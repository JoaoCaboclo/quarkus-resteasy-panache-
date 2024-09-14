package com.jcaboclo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto extends PanacheEntity {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_produto_id")
    private CategoriaProduto categoriaProduto;

}

