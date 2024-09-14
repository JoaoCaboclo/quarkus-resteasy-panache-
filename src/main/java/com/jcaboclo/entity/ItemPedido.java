package com.jcaboclo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class ItemPedido extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "pedido_venda_id", nullable = false)
    private PedidoVenda pedidoVenda;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    private int quantidade;
    private double PrecoUnitario;
}
