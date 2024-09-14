package com.jcaboclo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class PedidoVenda extends PanacheEntity {

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "pedidoVenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itensPedido; // Relação com ItemPedido

    // Adicionando um método para facilitar a obtenção dos produtos diretamente
    public List<Produto> getProdutos() {
        return itensPedido.stream()
                .map(ItemPedido::getProduto) // Navegando do ItemPedido para Produto
                .toList();
    }

    private double total;
}

