package br.com.nexustech.main;

import br.com.nexustech.exception.BanidoException;
import br.com.nexustech.model.Masmorra;
import br.com.nexustech.model.Matchmaker;
import br.com.nexustech.model.ModoCasual;
import br.com.nexustech.model.ModoJogo;
import br.com.nexustech.model.ModoRanqueado;

/**
 * Protocolo de Resiliência - Tratamento de Exceções (Exercícios 1 a 14).
 * O jogo é "blindado" para não fechar sozinho quando um erro ocorre.
 */
public class Main {

    public static void main(String[] args) {

        // Ex 1 e 2 - Bug do K/D (Divisão por zero -> ArithmeticException)
        int kills = 15;
        int deaths = 0;
        try {
            System.out.println("Taxa K/D: " + (kills / deaths));
        } catch (ArithmeticException e) {
            System.out.println("Taxa K/D: Jogador Invicto!");
        }

        // Ex 3 - Inventário bugado (ArrayIndexOutOfBoundsException)
        String[] inventario = new String[3];
        try {
            inventario[5] = "Espada";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Inventario cheio!");
        }

        // Ex 4 - O Fantasma (NullPointer tratado com programação defensiva, sem try-catch)
        String jogador = null;
        if (jogador != null) {
            System.out.println("Jogador: " + jogador);
        } else {
            System.out.println("Jogador desconectado");
        }

        // Ex 5, 6 e 7 - Queda de internet (Checked Exception + finally)
        try {
            conectarServidor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Fechando portas de rede do jogo...");
        }

        // Ex 9 - Masmorra fechada (exceção customizada Unchecked)
        Masmorra masmorra = new Masmorra();
        try {
            masmorra.entrar(20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Ex 14 - Batalha final: matchmaking com jogador banido (Checked Exception)
        Matchmaker matchmaker = new Matchmaker();
        ModoJogo casual = new ModoCasual();
        ModoJogo ranqueado = new ModoRanqueado();
        try {
            matchmaker.encontrarSala(casual, true); // jogador banido
        } catch (BanidoException e) {
            System.out.println(e.getMessage());
        }

        // Demonstração de matchmaking bem-sucedido
        try {
            matchmaker.encontrarSala(ranqueado, false);
        } catch (BanidoException e) {
            System.out.println(e.getMessage());
        }
    }

    // Ex 5 - Método que simula a queda do servidor (Checked Exception)
    public static void conectarServidor() throws Exception {
        throw new Exception("Servidor caiu!");
    }
}
