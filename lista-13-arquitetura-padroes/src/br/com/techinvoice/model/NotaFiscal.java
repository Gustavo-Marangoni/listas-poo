package br.com.techinvoice.model;

/** Ex 3 - Documento concreto: Nota Fiscal. */
public class NotaFiscal implements IDocumento {

    @Override
    public void gerarPDF() {
        System.out.println("Gerando Nota Fiscal com impostos...");
    }
}
