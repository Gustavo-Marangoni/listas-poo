package br.com.techinvoice.model;

/** Ex 3 - Documento concreto: Recibo. */
public class Recibo implements IDocumento {

    @Override
    public void gerarPDF() {
        System.out.println("Gerando Recibo simples de pagamento...");
    }
}
