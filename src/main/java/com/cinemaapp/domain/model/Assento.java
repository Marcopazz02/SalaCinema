package com.cinemaapp.domain.model;

public record Assento(String fileira, int numero) {
    public Assento {
        if (fileira == null || fileira.isBlank()) {
            throw new IllegalArgumentException("A fileira do assento não pode ser vazia.");
        }
        if (numero <= 0) {
            throw new IllegalArgumentException("O número do assento deve ser maior que zero.");
        }
    }
    public String codigo() {
        return fileira.toUpperCase() + "-" + numero;
    }
}

// criar enum pra linha e coluna