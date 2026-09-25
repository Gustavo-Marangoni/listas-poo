package br.com.nexustech.exception;

/**
 * Ex 8 - Exceção customizada não-verificada (RuntimeException)
 * para regra de negócio do RPG.
 */
public class NivelInsuficienteException extends RuntimeException {

    public NivelInsuficienteException() {
        super("Seu nivel e muito baixo para esta masmorra!");
    }
}
