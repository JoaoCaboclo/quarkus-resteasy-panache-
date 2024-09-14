package com.jcaboclo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;


@Entity
@Getter @Setter
@NoArgsConstructor
public class Vendedor extends PanacheEntity {

    private String nome;

    @OneToMany(mappedBy = "vendedor")
    private List<PedidoVenda> pedidos;
}

