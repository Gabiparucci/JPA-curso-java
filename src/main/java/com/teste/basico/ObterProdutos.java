package com.teste.basico;

import com.infra.DAO;
import com.modelo.basico.Produto;

import java.util.List;

public class ObterProdutos {
    public static void main(String[] args) {

    DAO<Produto> dao = new DAO<>(Produto.class);

    List<Produto> produtos = dao.obterTodos();
    produtos.forEach(i -> System.out.println(i.getNome()));

    double total = produtos.stream()
            .map(Produto::getPreco)
            .reduce(0.0, Double::sum);

        System.out.println("Total = " + total);

    }

}
