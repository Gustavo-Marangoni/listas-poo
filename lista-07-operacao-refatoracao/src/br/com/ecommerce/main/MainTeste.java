package br.com.ecommerce.main;

import br.com.ecommerce.exception.TipoFreteInvalidoException;
import br.com.ecommerce.model.CalculadoraFrete;
import br.com.ecommerce.model.FreteMotoboy;
import br.com.ecommerce.model.FretePac;
import br.com.ecommerce.model.FreteSedex;

/**
 * Teste de resiliência: prova que a arquitetura calcula fretes válidos
 * e trata o erro sem "crashar" o programa.
 */
public class MainTeste {

    public static void main(String[] args) {
        CalculadoraFrete calculadora = new CalculadoraFrete();
        double valorPedido = 100.00;

        try {
            System.out.println("Sedex:   R$ " + calculadora.processarFrete(valorPedido, new FreteSedex()));
            System.out.println("PAC:     R$ " + calculadora.processarFrete(valorPedido, new FretePac()));
            System.out.println("Motoboy: R$ " + calculadora.processarFrete(valorPedido, new FreteMotoboy()));

            // Força um erro: estratégia nula
            System.out.println("Frete nulo: R$ " + calculadora.processarFrete(valorPedido, null));

        } catch (TipoFreteInvalidoException e) {
            System.out.println("Erro tratado: " + e.getMessage());
        }
    }
}
