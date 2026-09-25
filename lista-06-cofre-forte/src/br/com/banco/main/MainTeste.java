package br.com.banco.main;

import br.com.banco.model.Agencia;
import br.com.banco.model.Cliente;
import br.com.banco.model.ContaBancaria;

public class MainTeste {
    public static void main(String[] args) {
        System.out.println("=== " + Agencia.NOME_BANCO + " ===");

        // 1. Dois clientes diferentes, mas com o MESMO CPF
        Cliente cliente1 = new Cliente("123.456.789-00", "Ana Souza", "ana@email.com");
        Cliente cliente2 = new Cliente("123.456.789-00", "Ana S.", "ana.souza@email.com");
        System.out.println(cliente1);
        System.out.println(cliente2);

        // 2. Testando a igualdade com equals (RN02)
        if (cliente1.equals(cliente2)) {
            System.out.println("Os clientes são IGUAIS (mesmo CPF).");
        } else {
            System.out.println("Os clientes são DIFERENTES.");
        }

        // 3. Conta com saldo de 50.0
        ContaBancaria conta = new ContaBancaria("0001-1", cliente1, 50.0);

        // 4. Saque de 50.0 deve ser negado por causa da taxa
        boolean sacou = conta.sacar(50.0);
        System.out.println("Saque de 50.0 realizado? " + sacou);
        System.out.println("Saldo atual: " + conta.getSaldo());

        // 5. Total de contas abertas
        System.out.println("Total de contas abertas: " + Agencia.getTotalContasAbertas());
    }
}
