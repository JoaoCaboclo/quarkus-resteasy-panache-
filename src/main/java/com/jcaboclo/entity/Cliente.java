package com.jcaboclo.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
public class Cliente extends PanacheEntity {

    @NotBlank
    private String nome;

    @NotBlank
    private String email;

    @NotBlank
    private String cep;  // CEP do cliente para validação em serviço externo

    @NotBlank
    private String creditCardNumber;  // Número de cartão de crédito para validação
}
