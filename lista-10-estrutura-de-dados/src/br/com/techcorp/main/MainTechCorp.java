package br.com.techcorp.main;

import br.com.techcorp.model.ControleDeAcesso;
import br.com.techcorp.model.Funcionario;

/**
 * Valida que a arquitetura previne registros duplicados na Sala Segura,
 * enquanto a catraca aceita múltiplas passagens.
 */
public class MainTechCorp {

    public static void main(String[] args) {
        ControleDeAcesso controle = new ControleDeAcesso();

        Funcionario f1 = new Funcionario("T-001", "Alice", "Analista");
        Funcionario f2 = new Funcionario("T-001", "Alice Duplicada", "Analista");

        System.out.println("--- Catraca (aceita historico de multiplas entradas) ---");
        controle.registrarPassagem(f1);
        controle.registrarPassagem(f2);

        System.out.println("\n--- Sala Segura (bloqueia matricula duplicada) ---");
        controle.concederAcessoSala(f1);
        controle.concederAcessoSala(f2); // deve exibir o Aviso

        System.out.println("\nTotal de passagens na catraca: " + controle.getHistoricoCatraca().size());
        System.out.println("Total autorizados na sala segura: " + controle.getAutorizadosSalaSegura().size());
    }
}
