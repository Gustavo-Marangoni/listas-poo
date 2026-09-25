package br.com.nexustech.model;

import br.com.nexustech.exception.NivelInsuficienteException;

/** Ex 9 - Masmorra que exige nível mínimo 50 para entrar. */
public class Masmorra {

    public void entrar(int nivelJogador) {
        if (nivelJogador < 50) {
            throw new NivelInsuficienteException();
        }
        System.out.println("Bem-vindo a masmorra, aventureiro de nivel " + nivelJogador + "!");
    }
}
