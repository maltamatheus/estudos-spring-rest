package br.com.estudos.domains.generics.utils;

import ch.qos.logback.core.testUtil.RandomUtil;

import java.util.List;

public class Sorteador<T> {
    public T sotearItem(List<T> lista){
        try {
            int idx = RandomUtil.getPositiveInt();
            if (idx > lista.size()){
                idx = idx%lista.size();
            }
            return lista.get(idx);
        } catch (IndexOutOfBoundsException e) {
            throw new IndiceNaoExistenteException("Índice não existente: \n"+e.getMessage());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
