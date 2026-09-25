package br.com.techcorp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * RN02 e RN03 - Controle de acesso do prédio.
 *  - Catraca: ArrayList (mantém ordem cronológica e aceita repetições).
 *  - Sala segura: HashSet (não permite matrículas duplicadas).
 */
public class ControleDeAcesso {

    // RN02 - Histórico cronológico com repetições
    private List<Funcionario> historicoCatraca = new ArrayList<>();

    // RN03 - Unicidade de matrícula na sala segura
    private Set<Funcionario> autorizadosSalaSegura = new HashSet<>();

    public void registrarPassagem(Funcionario f) {
        historicoCatraca.add(f);
        System.out.println("Catraca: passagem registrada para " + f.getNome()
                + " (matricula " + f.getMatricula() + ")");
    }

    public void concederAcessoSala(Funcionario f) {
        boolean inserido = autorizadosSalaSegura.add(f);
        if (inserido) {
            System.out.println("Acesso liberado para a Sala Segura");
        } else {
            System.out.println("Aviso: Matricula ja registrada na sala. Acesso nao permitido.");
        }
    }

    public List<Funcionario> getHistoricoCatraca() {
        return historicoCatraca;
    }

    public Set<Funcionario> getAutorizadosSalaSegura() {
        return autorizadosSalaSegura;
    }
}
