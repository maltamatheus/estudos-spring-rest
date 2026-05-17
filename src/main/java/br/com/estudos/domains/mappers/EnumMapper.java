package br.com.estudos.domains.mappers;

import br.com.estudos.domains.generics.utils.ValorNaoReconhecidoException;
import org.mapstruct.Named;

public class EnumMapper<T extends Enum<T>> {

    @Named("enumToString")
    public String enumToString(T tipoEnum) {
        if (tipoEnum == null) return null;
        return tipoEnum.name();
    }

    @Named("enumToInteger")
    public Integer enumToInteger(T tipoEnum) {
        if (tipoEnum == null) return null;
        return tipoEnum.ordinal();
    }

    // Para o MapStruct identificar o Enum de destino, a classe deve ser passada explicitamente
    @Named("stringToEnum")
    public T stringToEnum(String valor, Class<T> enumClass) {
        if (valor == null || valor.trim().isEmpty()) return null;
        try {
            return Enum.valueOf(enumClass, valor);
        } catch (Exception e) {
            throw new ValorNaoReconhecidoException("Valor não permitido para este Enum");
        }
    }

    // Corrigido para receber o Integer e a Class do Enum
    @Named("integerToEnum")
    public T integerToEnum(Integer valor, Class<T> enumClass) {
        if (valor == null) return null;
        T[] constants = enumClass.getEnumConstants();
        if (valor < 0 || valor >= constants.length) {
            throw new ValorNaoReconhecidoException("Índice fora do limite para este Enum");
        }
        return constants[valor];
    }
}