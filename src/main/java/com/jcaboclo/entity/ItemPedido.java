package com.jcaboclo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
@Getter @Setter
public class ItemPedido extends PanacheEntity {

    @ManyToOne
    private Produto produto;

    private int quantidade;

    private double precoUnitario;
}
