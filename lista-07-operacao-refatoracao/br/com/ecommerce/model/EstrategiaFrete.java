package br.com.ecommerce.model;

/**
 * Contrato do padrão Strategy. Cada transportadora implementa
 * a sua própria regra de cálculo sem que a calculadora precise conhecê-la.
 */
public interface EstrategiaFrete {
    double calcular(double valorPedido);
}
