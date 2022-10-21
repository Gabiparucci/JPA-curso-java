package com.teste.basico;

import com.infra.DAO;
import com.modelo.basico.Produto;

public class NovoProduto {
    public static void main(String[] args) {
        DAO <Produto> dao = new DAO<>(Produto.class);

        Produto produto = new Produto("Monitor", 789.45);
        dao.incluirAtomico(produto);
        System.out.println(produto.getId());
    }
}
