package app;

import model.Usuario;
import model.Video;

/** Q05 - Cenário de testes: valida a proteção da duração do vídeo. */
public class MainStreaming {

    public static void main(String[] args) {
        Usuario usuario = new Usuario("Carlos", "carlos@email.com", true);

        Video video1 = new Video("Aula de Java", 120);
        Video video2 = new Video("Aula de POO", -45); // duração inválida -> vira 1

        System.out.println(usuario);
        System.out.println("Duracao do video 1: " + video1.getDuracaoMinutos() + " min");
        System.out.println("Duracao final do video 2 (regra aplicada): " + video2.getDuracaoMinutos() + " min");
    }
}
