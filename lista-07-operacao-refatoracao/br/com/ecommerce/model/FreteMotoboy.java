package br.com.ecommerce.model;

/** Motoboy é uma taxa fixa de R$ 15,00 independente do valor do pedido. */
public class FreteMotoboy implements EstrategiaFrete {

    private static final double TAXA_FIXA = 15.00;

    @Override
    public double calcular(double valorPedido) {
        return TAXA_FIXA;
    }
}
