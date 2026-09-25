package br.com.nexustech.model;

import br.com.nexustech.exception.BanidoException;

/** Ex 13 - Sistema de matchmaking que combina polimorfismo e exceções. */
public class Matchmaker {

    public void encontrarSala(ModoJogo modo, boolean jogadorBanido) throws BanidoException {
        if (jogadorBanido) {
            throw new BanidoException();
        }
        modo.buscarPartida();
    }
}
