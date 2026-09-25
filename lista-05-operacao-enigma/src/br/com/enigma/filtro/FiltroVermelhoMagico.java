package br.com.enigma.filtro;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FiltroVermelhoMagico implements FiltroImagem {

    // Regra: se o canal RED do pixel for ÍMPAR, vira PRETO. Se for PAR, vira BRANCO.
    @Override
    public void aplicarFiltro(String caminhoEntrada, String caminhoSaida) {
        try {
            BufferedImage imagem = ImageIO.read(new File(caminhoEntrada));
            int largura = imagem.getWidth();
            int altura = imagem.getHeight();
            BufferedImage saida = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < altura; y++) {
                for (int x = 0; x < largura; x++) {
                    int rgb = imagem.getRGB(x, y);
                    int vermelho = (rgb >> 16) & 0xFF;
                    int novaCor = (vermelho % 2 != 0) ? 0x000000 : 0xFFFFFF;
                    saida.setRGB(x, y, novaCor);
                }
            }

            String formato = caminhoSaida.substring(caminhoSaida.lastIndexOf('.') + 1);
            ImageIO.write(saida, formato, new File(caminhoSaida));
        } catch (IOException e) {
            System.out.println("Erro ao processar a imagem: " + e.getMessage());
        }
    }
}
