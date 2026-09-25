package app;

import model.Pagamento;
import model.PagamentoCartao;
import model.PagamentoPix;
import model.ProcessadorPagamento;

/** Q14 - Cenário de testes: polimorfismo dinâmico sem if/else. */
public class MainPagamento {

    public static void main(String[] args) {
        ProcessadorPagamento processador = new ProcessadorPagamento();

        Pagamento pix = new PagamentoPix();
        Pagamento cartao = new PagamentoCartao();

        processador.finalizarCompra(150.00, pix);
        processador.finalizarCompra(300.00, cartao);
    }
}
