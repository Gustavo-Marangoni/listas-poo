package br.com.enigma.decodificador;

public class DecodificadorCesar implements Decodificador {
    private int chave;

    public DecodificadorCesar(int chave) {
        this.chave = chave;
    }

    @Override
    public String decodificar(String texto) {
        StringBuilder resultado = new StringBuilder();
        int desloc = ((chave % 26) + 26) % 26;
        for (char c : texto.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                resultado.append((char) ('A' + (c - 'A' - desloc + 26) % 26));
            } else if (c >= 'a' && c <= 'z') {
                resultado.append((char) ('a' + (c - 'a' - desloc + 26) % 26));
            } else {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }
}
