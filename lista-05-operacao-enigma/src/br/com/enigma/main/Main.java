package br.com.enigma.main;

import br.com.enigma.decodificador.Decodificador;
import br.com.enigma.decodificador.DecodificadorBase64;
import br.com.enigma.decodificador.DecodificadorCesar;
import br.com.enigma.filtro.FiltroImagem;
import br.com.enigma.filtro.FiltroVermelhoMagico;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final String PASTA = "arquivos/";

    public static void main(String[] args) throws IOException {
        // DIRETRIZ 2: A Ilusão Visual - lendo os bytes escondidos depois do fim do JPEG (FF D9)
        byte[] bytes = Files.readAllBytes(Paths.get(PASTA + "pista_01.jpg"));
        int fimJpeg = -1;
        for (int i = 0; i < bytes.length - 1; i++) {
            if ((bytes[i] & 0xFF) == 0xFF && (bytes[i + 1] & 0xFF) == 0xD9) {
                fimJpeg = i + 2;
            }
        }
        String escondido = new String(bytes, fimJpeg, bytes.length - fimJpeg, StandardCharsets.UTF_8).trim();
        System.out.println("[Pista 1] Texto oculto na imagem: " + escondido);

        Decodificador decodificador = new DecodificadorBase64();
        String pista = decodificador.decodificar(escondido);
        System.out.println("[Pista 1] Decodificado (Base64): " + pista);

        // Formato: "Chave_Cesar: 7 | Alvo: mensagem.txt"
        String[] partes = pista.split("\\|");
        int chave = Integer.parseInt(partes[0].split(":")[1].trim());
        String alvo = partes[1].split(":")[1].trim();

        // DIRETRIZ 3: O Elo Perdido - polimorfismo: a mesma variável agora aponta para outro decodificador
        String cifrado = new String(Files.readAllBytes(Paths.get(PASTA + alvo)), StandardCharsets.UTF_8).trim();
        System.out.println("[Pista 2] Conteúdo de " + alvo + ": " + cifrado);

        decodificador = new DecodificadorCesar(chave);
        String instrucao = decodificador.decodificar(cifrado);
        System.out.println("[Pista 2] Decodificado (César, chave " + chave + "): " + instrucao);

        // DIRETRIZ 4: O Ruído - aplicando o filtro no canal vermelho
        FiltroImagem filtro = new FiltroVermelhoMagico();
        filtro.aplicarFiltro(PASTA + "ruido.bmp", PASTA + "revelado.png");
        System.out.println("[Pista 3] Filtro aplicado! Abra o arquivo " + PASTA + "revelado.png para ver a URL do Cofre.");
    }
}
