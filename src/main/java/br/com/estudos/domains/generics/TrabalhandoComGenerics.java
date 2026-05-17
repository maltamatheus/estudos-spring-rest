package br.com.estudos.domains.generics;

import br.com.estudos.domains.Produto;
import br.com.estudos.domains.generics.utils.Sorteador;

import java.util.List;

public class TrabalhandoComGenerics {
    public static String retornaMistura(List<String> misturas){
        Sorteador<String> cardapio = new Sorteador<>();
        return cardapio.sotearItem(misturas);
    }

    public static Produto retornaProduto(List<Produto> produtos){
        Sorteador<Produto> estoque = new Sorteador<Produto>();
        return estoque.sotearItem(produtos);
    }
}
