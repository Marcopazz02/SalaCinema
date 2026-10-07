package com.cinemaapp;

import com.cinemaapp.domain.model.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Reserva> reservasExistentes = new ArrayList<>();

        // Instanciação de objetos iniciais.
        Filme filme1 = new Filme("O Diabo Veste Prada", 180);
        Cliente cliente1 = new Cliente("000.000.000-00", "Marco Paz");
        Assento assento = new Assento("C", 5);
        Preco preco = new Preco(2500);
        Preco pipoca = new Preco(5000);

        // Sessão 1: 19:00 às 21:30
        LocalDateTime inicio1 = LocalDateTime.of(2026, 10, 15, 21, 0);
        LocalDateTime fim1 = inicio1.plusMinutes(filme1.duracaoMinutos());
        Periodo periodo1 = new Periodo(inicio1, fim1);

        // Instanciação da reserva 1
        Reserva reserva1 = new Reserva(cliente1, assento, periodo1, preco, reservasExistentes);
        reservasExistentes.add(reserva1); // Adiciona a primeira reserva na lista

        System.out.println("Filme: " + filme1.titulo() + " / ID: " + filme1.id());
        System.out.println("Reserva feita para: " + reserva1.getCliente().nome());
        System.out.println("Assento: " + reserva1.getAssento().codigo());
        System.out.println("Duração da sessão: " + reserva1.getPeriodo().duracaoEmMinutos() + " min");
        System.out.println("Valor pago: " + reserva1.getPreco().formatado());

        // Adição pipoca
        reserva1.adicionarPreco(pipoca);
        System.out.println("Pipoca adicionada!");
        System.out.println("Novo preço a ser pago: " + reserva1.getPreco().formatado());
        System.out.println();
        System.out.println("------------------------------------------------------------------");

        // Atribuindo novos valores ao período
        Filme filme2 = new Filme("Titanic", 180);

        // Sessão 2: 19:00 às 21:30 (Mesmo horário da Sessão 1)
        LocalDateTime inicio2 = LocalDateTime.of(2026, 10, 15, 15, 0);
        LocalDateTime fim2 = inicio2.plusMinutes(filme2.duracaoMinutos());
        Periodo periodo2 = new Periodo(inicio2, fim2);

        // Novas instâncias de novos objetos (Mesmo assento A-3)
        Cliente cliente2 = new Cliente("111.111.111-11", "Ana Silva");
        Assento assento2 = new Assento("C", 5);
        Preco preco2 = new Preco(2500);

        Reserva reserva2 = new Reserva(cliente2, assento2, periodo2, preco2, reservasExistentes);

        System.out.println("Filme: " + filme2.titulo() + " / ID: " + filme2.id());
        System.out.println("Reserva feita para: " + reserva2.getCliente().nome());
        System.out.println("Assento: " + reserva2.getAssento().codigo());
        System.out.println("Duração da sessão: " + reserva2.getPeriodo().duracaoEmMinutos() + " min");
        System.out.println("Valor pago: " + reserva2.getPreco().formatado());
        System.out.println("ID DA RESERVA: "+reserva2.getId());
    }
}