package model;

/** Q12 - Implementação concreta: pagamento via Pix. */
public class PagamentoPix implements Pagamento {

    @Override
    public void processar(double valor) {
        System.out.println("Gerando QR Code Pix no valor de R$ " + valor);
    }
}
