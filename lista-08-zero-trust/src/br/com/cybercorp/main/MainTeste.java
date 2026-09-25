package br.com.cybercorp.main;

import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.Departamento;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.SistemaSeguranca;
import br.com.cybercorp.model.Veiculo;

/**
 * Campo de provas: valida que a arquitetura resiste ao ataque de clonagem
 * e demonstra a rigidez do array da garagem.
 */
public class MainTeste {

    public static void main(String[] args) {
        Departamento ti = new Departamento("Tecnologia da Informacao", "3o andar");
        Funcionario func = new Funcionario("Ana Souza", "111.222.333-44", ti);
        Veiculo carro = new Veiculo("ABC-1234", "Sedan Preto");

        SistemaSeguranca sistema = new SistemaSeguranca(2);

        Credencial c1 = new Credencial("FFF-999", true, func);
        Credencial clone = new Credencial("FFF-999", true, func);

        System.out.println("--- Teste da Catraca (aceita repeticao) ---");
        sistema.registrarCatraca(func);
        sistema.registrarCatraca(func);

        System.out.println("\n--- Teste do Cofre (Zero Trust) ---");
        sistema.acessarCofre(c1);
        sistema.acessarCofre(clone);

        System.out.println("\n--- Teste da Garagem (rigidez do Array) ---");
        sistema.estacionarVeiculo(carro, 0);
        try {
            sistema.estacionarVeiculo(carro, 5);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Excecao capturada (vaga inexistente): " + e.getMessage());
        }
    }
}
