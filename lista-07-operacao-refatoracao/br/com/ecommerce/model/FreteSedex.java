package br.com.ecommerce.model;

/** Sedex cobra 10% do valor do pedido. */
public class FreteSedex implements EstrategiaFrete {

    @Override
    public double calcular(double valorPedido) {
        return valorPedido * 0.10;
    }
}
