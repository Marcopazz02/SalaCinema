package com.cinemaapp.domain.model;

public record Preco(int valorEmCentavos) {

    public Preco {
        if (valorEmCentavos < 0) {
            throw new IllegalArgumentException("O preço em centavos não pode ser negativo.");
        }
    }
    public String formatado() {
        int reais = valorEmCentavos / 100;
        int centavos = valorEmCentavos % 100;
        return String.format("R$ %d,%02d", reais, centavos);
    }
    public Preco somar(Preco outro) {
        if (outro == null) {
            throw new IllegalArgumentException("O preço a somar não pode ser nulo.");
        }
        return new Preco(this.valorEmCentavos + outro.valorEmCentavos());
    }
}