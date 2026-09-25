package model;

/**
 * Entidade Usuario (Questões 01, 03, 06, 07, 08, 09).
 * Atributos encapsulados, identidade lógica por e-mail, constante da
 * plataforma e contador estático de instâncias.
 */
public class Usuario {

    // Q08 - Constante global da classe (não pertence às instâncias)
    public static final String NOME_PLATAFORMA = "JavaFlix";

    // Q09 - Contador global de instâncias
    private static int totalUsuarios = 0;

    // Q03 - Atributos encapsulados
    private String nome;
    private String email;
    private boolean ativo;

    public Usuario(String nome, String email, boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.ativo = ativo;
        totalUsuarios++; // Q09
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    // Q09 - Método estático de consulta da métrica
    public static int getTotalUsuarios() {
        return totalUsuarios;
    }

    // Q06 - Representação textual
    @Override
    public String toString() {
        return "Usuário: " + nome + " | Contato: " + email + " | Ativo: " + ativo;
    }

    // Q07 - Igualdade lógica por e-mail
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario outro = (Usuario) obj;
        return email != null ? email.equals(outro.email) : outro.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }
}
