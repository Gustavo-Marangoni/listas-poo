package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Q15, Q17, Q18, Q19 - Sede corporativa com três estruturas de dados:
 *  - Array fixo de 3 vagas (garagem)
 *  - List (histórico da catraca, aceita repetições)
 *  - Set (acesso ao cofre, garante unicidade)
 */
public class Sede {

    // Q15 - Array com capacidade fixa de 3 posições
    private String[] vagasGaragem = new String[3];

    // Q17 - Histórico cronológico, aceita entradas repetidas
    private List<Credencial> historicoCatraca = new ArrayList<>();

    // Q18 - Acesso restrito, garante unicidade
    private Set<Credencial> acessoCofre = new HashSet<>();

    // Q19 - Aloca a placa na vaga indicada (pode lançar ArrayIndexOutOfBoundsException)
    public void estacionarVeiculo(String placa, int vaga) {
        vagasGaragem[vaga] = placa;
        System.out.println("Veiculo " + placa + " estacionado na vaga " + vaga);
    }

    // Q19 - Registra a passagem na catraca (histórico)
    public void registrarPassagemCatraca(Credencial c) {
        historicoCatraca.add(c);
        System.out.println("Catraca: passagem registrada para " + c.getCodigoHex()
                + " (total no historico: " + historicoCatraca.size() + ")");
    }

    // Q19 - Autoriza a entrada no cofre avaliando o retorno booleano do add()
    public void autorizarEntradaCofre(Credencial c) {
        boolean inserido = acessoCofre.add(c);
        if (inserido) {
            System.out.println("Cofre: acesso autorizado para " + c.getCodigoHex());
        } else {
            System.out.println("Alerta de Seguranca: Tentativa de acesso duplicado com credencial ja ativa no cofre");
        }
    }
}
