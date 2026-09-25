package model;

/**
 * Q13 - Inversão de Dependência: depende da abstração Pagamento,
 * nunca das classes concretas. Aciona o método processar polimorficamente.
 */
public class ProcessadorPagamento {

    public void finalizarCompra(double valor, Pagamento formaPagamento) {
        formaPagamento.processar(valor);
    }
}
