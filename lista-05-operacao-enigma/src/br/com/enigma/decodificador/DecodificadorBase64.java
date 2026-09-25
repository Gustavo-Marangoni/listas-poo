package br.com.enigma.decodificador;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DecodificadorBase64 implements Decodificador {

    @Override
    public String decodificar(String texto) {
        byte[] bytes = Base64.getDecoder().decode(texto.trim());
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
