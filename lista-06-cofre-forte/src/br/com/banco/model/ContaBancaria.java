package br.com.banco.model;

public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private Cliente titular;

    public ContaBancaria(String numeroConta, Cliente titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
        Agencia.registrarNovaConta(); // RN03: toda conta criada é contabilizada
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    // Saldo não possui set (RN03)
    public double getSaldo() {
        return saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    // Saque só ocorre se saldo >= valor + TAXA_SAQUE (RN03)
    public boolean sacar(double valor) {
        double total = valor + Agencia.TAXA_SAQUE;
        if (saldo >= total) {
            saldo -= total;
            return true;
        }
        return false;
    }
}
