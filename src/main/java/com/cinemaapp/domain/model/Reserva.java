package com.cinemaapp.domain.model;

import java.util.List;
import java.util.UUID;

public class Reserva {
    private final String id;
    private final Cliente cliente;
    private final Assento assento;
    private final Periodo periodo;
    private Preco preco;


    public Reserva(String id, Cliente cliente, Assento assento, Periodo periodo, Preco preco, List<Reserva> reservasExistentes) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("O ID da reserva não pode ser nulo ou vazio.");
        }
        if (cliente == null || assento == null || periodo == null || preco == null) {
            throw new IllegalArgumentException("Nenhum parâmetro da reserva pode ser nulo.");
        }

        // Validação no construtor (Fail-Fast): utiliza o seu próprio método conflitaCom
        if (reservasExistentes != null) {
            for (Reserva existente : reservasExistentes) {
                if (existente.conflitaCom(assento, periodo)) {
                    throw new IllegalArgumentException(
                            "Não foi possível criar a reserva: o assento " + assento.codigo() +
                                    " já está reservado no horário informado."
                    );
                }
            }
        }

        this.id = id;
        this.cliente = cliente;
        this.assento = assento;
        this.periodo = periodo;
        this.preco = preco;
    }

    public Reserva(Cliente cliente, Assento assento, Periodo periodo, Preco preco, List<Reserva> reservasExistentes) {
        this(UUID.randomUUID().toString(), cliente, assento, periodo, preco, reservasExistentes);
    }

    public Reserva(Cliente cliente, Assento assento, Periodo periodo, Preco preco) {
        this(cliente, assento, periodo, preco, List.of());
    }

    public boolean conflitaCom(Assento outroAssento, Periodo outroPeriodo) {
        if (outroAssento == null || outroPeriodo == null) {
            return false;
        }
        boolean mesmoAssento = this.assento.equals(outroAssento);
        boolean mesmoHorario = this.periodo.validaSobreposicaoReservas(outroPeriodo);
        return mesmoAssento && mesmoHorario;
    }

    public boolean conflitaCom(Reserva outraReserva) {
        if (outraReserva == null) return false;
        return conflitaCom(outraReserva.getAssento(), outraReserva.getPeriodo());
    }

    public Cliente getCliente() { return cliente; }
    public String getId() { return id; }
    public Assento getAssento() { return assento; }
    public Periodo getPeriodo() { return periodo; }
    public Preco getPreco() { return preco; }

    public void adicionarPreco(Preco outroPreco) {
        if (outroPreco == null) {
            throw new IllegalArgumentException("O preço adicional não pode ser nulo.");
        }
        this.preco = this.preco.somar(outroPreco);
    }
}