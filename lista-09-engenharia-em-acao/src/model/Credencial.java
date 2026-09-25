package model;

import java.util.Objects;

/**
 * Q16 - Entidade Credencial. Identidade lógica pelo codigoHex,
 * com equals() e hashCode() consistentes para uso em coleções baseadas em hash.
 */
public class Credencial {

    private String codigoHex;

    public Credencial(String codigoHex) {
        this.codigoHex = codigoHex;
    }

    public String getCodigoHex() {
        return codigoHex;
    }

    public void setCodigoHex(String codigoHex) {
        this.codigoHex = codigoHex;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Credencial that = (Credencial) obj;
        return Objects.equals(codigoHex, that.codigoHex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoHex);
    }

    @Override
    public String toString() {
        return "Credencial{codigoHex='" + codigoHex + "'}";
    }
}
