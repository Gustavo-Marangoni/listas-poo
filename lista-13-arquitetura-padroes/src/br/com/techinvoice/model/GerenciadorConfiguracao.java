package br.com.techinvoice.model;

/**
 * Ex 1 e 2 - Singleton com inicialização preguiçosa (lazy).
 * Construtor privado impede o uso de 'new' em outras classes,
 * garantindo uma única instância na memória.
 */
public class GerenciadorConfiguracao {

    // Ex 2.1 - Única instância da classe
    private static GerenciadorConfiguracao instancia;

    private String apiKey = "AWS-12345-KEY";

    // Ex 1 - Construtor privado (bloqueia 'new' externo)
    private GerenciadorConfiguracao() {
    }

    // Ex 2.2 e 2.3 - Ponto de acesso global com lazy initialization
    public static GerenciadorConfiguracao getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorConfiguracao();
        }
        return instancia;
    }

    public String getApiKey() {
        return apiKey;
    }
}
