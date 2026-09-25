package br.com.techinvoice.main;

import br.com.techinvoice.model.DocumentoFactory;
import br.com.techinvoice.model.GerenciadorConfiguracao;
import br.com.techinvoice.model.IDocumento;

/** Ex 5 - Teste de integração dos padrões Singleton e Factory. */
public class Main {

    public static void main(String[] args) {
        // 1. Singleton - captura a instância e imprime a apiKey
        GerenciadorConfiguracao gen1 = GerenciadorConfiguracao.getInstance();
        System.out.println("API Key: " + gen1.getApiKey());

        // 2. Prova que a segunda "instância" é o mesmo objeto na memória
        GerenciadorConfiguracao gen2 = GerenciadorConfiguracao.getInstance();
        if (gen1 == gen2) {
            System.out.println("gen1 e gen2 apontam para o MESMO endereco de memoria (Singleton OK).");
        } else {
            System.out.println("Falha: instancias diferentes.");
        }

        // 3. Factory cria uma Nota Fiscal
        IDocumento nf = DocumentoFactory.criarDocumento("NF");
        nf.gerarPDF();

        // 4. Factory com tipo inválido -> IllegalArgumentException tratada
        try {
            IDocumento boleto = DocumentoFactory.criarDocumento("BOLETO");
            boleto.gerarPDF();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro tratado: " + e.getMessage());
        }
    }
}
