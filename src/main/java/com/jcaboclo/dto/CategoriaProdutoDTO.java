package com.jcaboclo.dto;

import com.jcaboclo.entity.CategoriaProduto;

public record CategoriaProdutoDTO(Long id, String nome) {

    // Converter de CategoriaProduto para CategoriaProdutoDTO
    public static CategoriaProdutoDTO fromEntity(CategoriaProduto categoriaProduto) {
        return new CategoriaProdutoDTO(categoriaProduto.id, categoriaProduto.nome);
    }

    // Converter de CategoriaProdutoDTO para CategoriaProduto
    public CategoriaProduto toEntity() {
        CategoriaProduto categoriaProduto = new CategoriaProduto();
        categoriaProduto.id = this.id;
        categoriaProduto.nome = this.nome;
        return categoriaProduto;
    }
}
