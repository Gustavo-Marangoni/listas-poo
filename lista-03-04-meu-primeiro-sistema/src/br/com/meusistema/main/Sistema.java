package br.com.meusistema.main;

// O Sistema precisa avisar que vai usar o Carro do outro "bairro".
import br.com.meusistema.model.Carro;

public class Sistema {
    public static void main(String[] args) {
        System.out.println("Iniciando o sistema...");

        // Criando o objeto (Construindo o Carro 1)
        Carro meuCarro = new Carro();
        meuCarro.setModelo("Fusca");
        meuCarro.setCor("Azul");
        meuCarro.setVelocidade(-500); // Tentando hackear novamente

        // Chamando o método (Comportamento)
        meuCarro.buzinar();
        System.out.println("Velocidade atual do " + meuCarro.getModelo() + ": " + meuCarro.getVelocidade() + " km/h");

        // Desafio Rápido: Carro 2, de outro modelo e cor
        Carro carro2 = new Carro();
        carro2.setModelo("Gol");
        carro2.setCor("Prata");
        carro2.setVelocidade(80);
        carro2.buzinar();
        System.out.println("Velocidade atual do " + carro2.getModelo() + ": " + carro2.getVelocidade() + " km/h");
    }
}
