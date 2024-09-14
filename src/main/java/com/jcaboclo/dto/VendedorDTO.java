package com.jcaboclo.dto;

import com.jcaboclo.entity.Vendedor;

public record VendedorDTO(Long id, String nome) {

    public static VendedorDTO fromEntity(Vendedor vendedor) {
        return new VendedorDTO(vendedor.id, vendedor.getNome());
    }

    public Vendedor toEntity() {
        Vendedor vendedor = new Vendedor();
        vendedor.id = this.id;
        vendedor.setNome(this.nome);
        return vendedor;
    }
}

