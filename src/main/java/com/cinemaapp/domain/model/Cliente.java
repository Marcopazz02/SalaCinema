package com.cinemaapp.domain.model;

public record Cliente(String cpf, String nome) {
    public Cliente {
        if (cpf == null || cpf.isBlank()) throw new IllegalArgumentException("CPF inválido.");
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome inválido.");
    }
}