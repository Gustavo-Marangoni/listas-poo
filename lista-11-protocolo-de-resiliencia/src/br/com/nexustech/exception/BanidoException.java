package br.com.nexustech.exception;

/**
 * Ex 12 - Exceção verificada (Checked). Herda de Exception,
 * obrigando o tratamento explícito com try-catch ou throws.
 */
public class BanidoException extends Exception {

    public BanidoException() {
        super("Jogador Banido!");
    }
}
