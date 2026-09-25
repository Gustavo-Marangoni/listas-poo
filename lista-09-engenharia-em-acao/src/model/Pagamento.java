package model;

/** Q11 - Contrato operacional para qualquer modalidade de cobrança. */
public interface Pagamento {
    void processar(double valor);
}
