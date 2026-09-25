package app;

import model.Credencial;
import model.Sede;

/** Q20 - Cenário de testes: valida limites das estruturas (List, Set e Array). */
public class MainSeguranca {

    public static void main(String[] args) {
        Sede sede = new Sede();
        Credencial cred = new Credencial("HEX-ABC-123");

        System.out.println("--- Catraca (aceita repeticao) ---");
        sede.registrarPassagemCatraca(cred);
        sede.registrarPassagemCatraca(cred);

        System.out.println("\n--- Cofre (bloqueia duplicidade) ---");
        sede.autorizarEntradaCofre(cred);
        sede.autorizarEntradaCofre(cred);

        System.out.println("\n--- Garagem (rigidez do array de 3 vagas) ---");
        sede.estacionarVeiculo("AAA-0001", 0);
        sede.estacionarVeiculo("BBB-0002", 1);
        sede.estacionarVeiculo("CCC-0003", 2);
        try {
            sede.estacionarVeiculo("DDD-0004", 3); // índice inexistente
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException capturada: indice 3 nao existe (array fixo de 3).");
        }
    }
}
