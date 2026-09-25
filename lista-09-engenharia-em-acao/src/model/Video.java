package model;

/**
 * Entidade Video (Questões 02, 03, 04).
 * Regra: duração menor ou igual a zero é ignorada e definida como 1 minuto.
 */
public class Video {

    private String titulo;
    private int duracaoMinutos;

    // Q04 - Construtor com inicialização obrigatória (executa validações)
    public Video(String titulo, int duracaoMinutos) {
        this.titulo = titulo;
        setDuracaoMinutos(duracaoMinutos);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    // Q03 - Valida a duração: valor inválido (<= 0) vira exatamente 1 minuto
    public void setDuracaoMinutos(int duracaoMinutos) {
        if (duracaoMinutos <= 0) {
            this.duracaoMinutos = 1;
        } else {
            this.duracaoMinutos = duracaoMinutos;
        }
    }

    @Override
    public String toString() {
        return "Video{titulo='" + titulo + "', duracaoMinutos=" + duracaoMinutos + "}";
    }
}
