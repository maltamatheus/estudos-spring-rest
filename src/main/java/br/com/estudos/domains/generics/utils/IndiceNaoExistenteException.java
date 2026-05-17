package br.com.estudos.domains.generics.utils;

public class IndiceNaoExistenteException extends RuntimeException{
    public IndiceNaoExistenteException(String message) {
        super(message);
    }
}
