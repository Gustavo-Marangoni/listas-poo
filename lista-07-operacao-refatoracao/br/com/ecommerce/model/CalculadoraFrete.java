package br.com.ecommerce.model;

import br.com.ecommerce.exception.TipoFreteInvalidoException;

/**
 * Calculadora refatorada: não conhece mais as regras de cada transportadora.
 * Apenas recebe uma estratégia pronta e a aciona (Inversão de Dependência).
 */
public class CalculadoraFrete {

    /**
     * Processa o frete delegando o cálculo à estratégia recebida.
     *
     * @param valorPedido valor base do pedido
     * @param estrategia  estratégia de frete a ser aplicada
     * @return valor do frete calculado
     * @throws TipoFreteInvalidoException se a estratégia for nula
     */
    public double processarFrete(double valorPedido, EstrategiaFrete estrategia) {
        if (estrategia == null) {
            throw new TipoFreteInvalidoException("Frete invalido: nenhuma estrategia de frete foi informada.");
        }
        return estrategia.calcular(valorPedido);
    }
}
