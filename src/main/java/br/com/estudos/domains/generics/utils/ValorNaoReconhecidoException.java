package br.com.estudos.domains.generics.utils;

public class ValorNaoReconhecidoException extends RuntimeException {
    public ValorNaoReconhecidoException(String msg) {
        super(msg);
    }
}
