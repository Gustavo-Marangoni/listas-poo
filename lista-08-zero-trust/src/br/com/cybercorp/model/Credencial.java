package br.com.cybercorp.model;

import java.util.Objects;

/**
 * A identidade da credencial é determinada exclusivamente pelo codigoHex.
 * Dois crachás com o mesmo código são tratados como idênticos, mesmo sendo
 * objetos diferentes na memória (proteção contra "crachá clonado").
 */
public class Credencial {

    private String codigoHex;
    private boolean ativa;
    private Funcionario titular;

    public Credencial(String codigoHex, boolean ativa, Funcionario titular) {
        this.codigoHex = codigoHex;
        this.ativa = ativa;
        this.titular = titular;
    }

    public String getCodigoHex() {
        return codigoHex;
    }

    public void setCodigoHex(String codigoHex) {
        this.codigoHex = codigoHex;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Funcionario getTitular() {
        return titular;
    }

    public void setTitular(Funcionario titular) {
        this.titular = titular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credencial that = (Credencial) o;
        return Objects.equals(codigoHex, that.codigoHex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoHex);
    }

    @Override
    public String toString() {
        return "Credencial{codigoHex='" + codigoHex + "', ativa=" + ativa
                + ", titular=" + (titular != null ? titular.getNome() : "null") + "}";
    }
}
