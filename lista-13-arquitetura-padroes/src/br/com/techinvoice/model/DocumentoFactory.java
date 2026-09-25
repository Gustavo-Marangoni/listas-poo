package br.com.techinvoice.model;

/**
 * Ex 4 - Factory: centraliza a criação de documentos, evitando 'new'
 * das classes concretas espalhado pelo código de negócio.
 */
public class DocumentoFactory {

    public static IDocumento criarDocumento(String tipo) {
        if ("NF".equalsIgnoreCase(tipo)) {
            return new NotaFiscal();
        } else if ("RECIBO".equalsIgnoreCase(tipo)) {
            return new Recibo();
        } else {
            throw new IllegalArgumentException("Documento invalido: tipo '" + tipo + "' nao reconhecido.");
        }
    }
}
