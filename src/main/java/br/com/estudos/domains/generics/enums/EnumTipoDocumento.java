package br.com.estudos.domains.generics.enums;

import br.com.estudos.domains.generics.utils.ValorNaoReconhecidoException;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum EnumTipoDocumento {
    RG(1,"Registro Geral"),
    CPF(2, "Cadastro de Pessoa Física"),
    CNH(3, "Carteira Nacional de Habilitação");

    EnumTipoDocumento(int id, String valor){
        this.id = id;
        this.valor = valor;
    }

    private int id;
    private String valor;

    public int getId() {
        return id;
    }
    public String getValor() {
        return valor;
    }

    public static EnumTipoDocumento getById(Integer idTipoDocumento){
        if(idTipoDocumento == null || idTipoDocumento <= 0){
            throw new ValorNaoReconhecidoException("Id Inválido para Enumeradores");
        }
         return Arrays.stream(EnumTipoDocumento.values()).filter(e -> {
            return e.getId() == idTipoDocumento;
        }).collect(Collectors.toList()).get(0);
    }
}
