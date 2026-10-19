package com.cinemaapp.domain.model;
import java.util.UUID;

public record Filme(String id, String titulo, int duracaoMinutos) {
    public Filme {
        if (id == null) {
            throw new IllegalArgumentException("O ID do filme não pode ser vazio.");
        }
        if (titulo == null) {
            throw new IllegalArgumentException("O título do filme não pode ser vazio.");
        }
        if (duracaoMinutos <= 0) {
            throw new IllegalArgumentException("A duração deve ser maior que zero.");
        }
    }

    public Filme(String titulo, int duracaoMinutos) {
        this(UUID.randomUUID().toString(), titulo, duracaoMinutos);
    }
}