package app;

import model.Usuario;

/** Q10 - Cenário de testes: igualdade lógica, constante e contador estático. */
public class MainMemoria {

    public static void main(String[] args) {
        Usuario u1 = new Usuario("Ana", "ana@email.com", true);
        Usuario u2 = new Usuario("Ana Clone", "ana@email.com", false);

        if (u1.equals(u2)) {
            System.out.println("Os usuarios sao logicamente iguais (mesmo e-mail).");
        } else {
            System.out.println("Os usuarios sao diferentes.");
        }

        // Acesso direto a partir da classe, sem instâncias
        System.out.println("Plataforma: " + Usuario.NOME_PLATAFORMA);
        System.out.println("Total de usuarios criados: " + Usuario.getTotalUsuarios());
    }
}
