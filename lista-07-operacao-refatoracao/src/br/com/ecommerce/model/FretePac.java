package br.com.ecommerce.model;

/** PAC cobra 5% do valor do pedido. */
public class FretePac implements EstrategiaFrete {

    @Override
    public double calcular(double valorPedido) {
        return valorPedido * 0.05;
    }
}
