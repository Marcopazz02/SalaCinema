package com.cinemaapp.domain.model;

import java.time.LocalDateTime;
import java.time.Duration;

public record Periodo(LocalDateTime inicio, LocalDateTime fim) {
    public Periodo {
        if (inicio == null || fim == null) throw new IllegalArgumentException("Horários não podem ser nulos.");
        if (!fim.isAfter(inicio)) throw new IllegalArgumentException("Fim deve ser depois do início.");
    }

    public long duracaoEmMinutos() {
        return Duration.between(inicio, fim).toMinutes();
    }
    public boolean validaSobreposicaoReservas(Periodo novaReserva){
        if (novaReserva == null ) {
            return false;
        }
        return this.inicio.isBefore(novaReserva.fim()) && this.fim.isAfter(novaReserva.inicio());
    }

}