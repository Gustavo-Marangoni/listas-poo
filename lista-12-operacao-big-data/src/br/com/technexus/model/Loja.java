package br.com.technexus.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Relatórios da loja reescritos com Streams e Lambdas (sem for/if).
 */
public class Loja {

    private List<Produto> catalogo = new ArrayList<>();

    // Ex 2 - Cadastro tradicional
    public void cadastrar(Produto p) {
        this.catalogo.add(p);
    }

    // Ex 3 - Filtra produtos por categoria (filter + toList)
    public List<Produto> buscarPorCategoria(String catDesejada) {
        return this.catalogo.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(catDesejada))
                .toList();
    }

    // Ex 4 - Soma o patrimônio total em estoque (mapToDouble + sum)
    public double calcularPatrimonioTotal() {
        return this.catalogo.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
    }

    // Ex 5 - Pipeline: filtra por categoria, extrai o preço e soma
    public double calcularTotalPorCategoria(String catDesejada) {
        return this.catalogo.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(catDesejada))
                .mapToDouble(Produto::getPreco)
                .sum();
    }
}
