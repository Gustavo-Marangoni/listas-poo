package br.com.enigma.decodificador;

public class DecodificadorReverso implements Decodificador {

    @Override
    public String decodificar(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }
}
