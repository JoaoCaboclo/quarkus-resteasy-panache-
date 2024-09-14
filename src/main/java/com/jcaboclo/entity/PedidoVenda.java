package com.jcaboclo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
public class PedidoVenda extends PanacheEntity {

    @ManyToOne
    private Vendedor vendedor;

    @ManyToOne
    private Cliente cliente;  // Associa o cliente à venda

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_venda_id")
    private List<ItemPedido> itens;

    private double total;
}

