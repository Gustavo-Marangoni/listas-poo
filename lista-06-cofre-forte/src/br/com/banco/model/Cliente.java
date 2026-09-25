package br.com.banco.model;

import java.util.Objects;

public class Cliente {
    private final String cpf;
    private String nome;
    private String email;

    public Cliente(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    // CPF não possui set: jamais pode ser alterado após a criação do objeto (RN02)
    public String getCpf() {
        return cpf;
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

    // Dois clientes são iguais se, e somente se, possuírem o mesmo CPF (RN02)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cliente outro = (Cliente) obj;
        return Objects.equals(cpf, outro.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }

    // Oculta o CPF por segurança (LGPD)
    @Override
    public String toString() {
        return "Cliente: " + nome + " | Contato: " + email;
    }
}
