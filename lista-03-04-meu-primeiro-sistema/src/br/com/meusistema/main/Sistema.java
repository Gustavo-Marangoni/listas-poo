package br.com.meusistema.main;

// O Sistema precisa avisar que vai usar o Carro do outro "bairro".
import br.com.meusistema.model.Carro;

public class Sistema {
    public static void main(String[] args) {
        System.out.println("Iniciando o sistema...");

        // Criando o objeto (Construindo o Carro 1)
        Carro meuCarro = new Carro();
        meuCarro.modelo = "Fusca";
        meuCarro.cor = "Azul";

        // Chamando o método (Comportamento)
        meuCarro.buzinar();

        // Desafio Rápido: Carro 2, de outro modelo e cor
        Carro carro2 = new Carro();
        carro2.modelo = "Gol";
        carro2.cor = "Prata";
        carro2.buzinar();
    }
}
