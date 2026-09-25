package br.com.cybercorp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Núcleo de segurança do prédio. Demonstra três estruturas de dados:
 *  - Array (garagem)  : capacidade fixa, acesso por índice.
 *  - List  (catraca)  : histórico cronológico, aceita repetições.
 *  - Set   (cofre)    : unicidade absoluta (Zero Trust).
 */
public class SistemaSeguranca {

    private final Veiculo[] vagasGaragem;
    private final List<Funcionario> catracaPrincipal = new ArrayList<>();
    private final Set<Credencial> cofreFisico = new HashSet<>();

    public SistemaSeguranca(int totalVagas) {
        this.vagasGaragem = new Veiculo[totalVagas];
    }

    /** Aloca o veículo na posição exata do array (pode lançar ArrayIndexOutOfBoundsException). */
    public void estacionarVeiculo(Veiculo veiculo, int vaga) {
        vagasGaragem[vaga] = veiculo;
        System.out.println("Garagem: Veiculo " + veiculo.getPlaca() + " estacionado na vaga " + vaga);
    }

    /** Registra a passagem na catraca. Aceita o mesmo funcionário múltiplas vezes. */
    public void registrarCatraca(Funcionario funcionario) {
        catracaPrincipal.add(funcionario);
        System.out.println("Catraca: Acesso liberado para " + funcionario.getNome());
    }

    /** Tenta liberar o cofre. O Set bloqueia credenciais clonadas (mesmo codigoHex). */
    public void acessarCofre(Credencial credencial) {
        boolean inserido = cofreFisico.add(credencial);
        if (inserido) {
            String nomeTitular = credencial.getTitular() != null ? credencial.getTitular().getNome() : "Desconhecido";
            System.out.println("Cofre: Acesso CONCEDIDO. Bem-vindo(a) " + nomeTitular);
        } else {
            System.out.println("ALERTA MAXIMO: Credencial " + credencial.getCodigoHex()
                    + " bloqueada! Tentativa de clonagem detectada.");
        }
    }
}
