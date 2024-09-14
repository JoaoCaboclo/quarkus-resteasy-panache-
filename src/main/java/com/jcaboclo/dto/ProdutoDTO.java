package com.jcaboclo.dto;

import com.jcaboclo.entity.CategoriaProduto;
import com.jcaboclo.entity.Produto;


public record ProdutoDTO(Long id, String nome, double preco, Long categoriaId) {

    // Método para converter de Produto para ProdutoDTO
    public static ProdutoDTO fromEntity(Produto produto) {
        return new ProdutoDTO(produto.id, produto.getNome(), produto.getPreco(),
                produto.getCategoriaProduto() != null ? produto.getCategoriaProduto().id : null);
    }

    // Método para converter de ProdutoDTO para Produto
    public Produto toEntity(CategoriaProduto categoriaProduto) {
        Produto produto = new Produto();
        produto.id = this.id;
        produto.setNome(this.nome);
        produto.setPreco(this.preco);
        produto.setCategoriaProduto(categoriaProduto);
        return produto;
    }
}

