package br.com.ecommerce.exception;

/**
 * Exceção customizada não-verificada (Unchecked) lançada quando
 * uma estratégia de frete inválida (nula) é informada.
 */
public class TipoFreteInvalidoException extends RuntimeException {

    public TipoFreteInvalidoException(String mensagem) {
        super(mensagem);
    }
}
