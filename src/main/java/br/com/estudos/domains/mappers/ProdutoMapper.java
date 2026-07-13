package br.com.estudos.domains.mappers;

import br.com.estudos.domains.dto.ProdutoDTO;
import br.com.estudos.domains.enums.EnumTipoProduto;
import br.com.estudos.domains.generics.enums.EnumTipoDocumento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EnumMapper.class})
public interface ProdutoMapper {

    @Mapping(source = "tipoProduto",target="tipo", qualifiedByName = "stringToEnum")
    @Mapping(source = "tipoDocumento", target="tipoDocto", qualifiedByName = "integerToEnum")
    Produto toProduto(ProdutoDTO dto);
    @Mapping(source = "tipo",target="tipoProduto", qualifiedByName = "enumToString")
    @Mapping(source = "tipoDocto", target="tipoDocumento", qualifiedByName = "enumToInteger")
    ProdutoDTO toProdutoDTO(Produto produto);
    List<ProdutoDTO> toListDTO(List<Produto> listaProduto);
    List<Produto> toListProduto(List<ProdutoDTO> dtos);

    @Named("stringToEnum")
    default EnumTipoProduto stringToEnum(String valor){
        return EnumTipoProduto.valueOf(valor.toUpperCase());
    }
    @Named("enumToString")
    default String stringToEnum(EnumTipoProduto enumTipoProduto){
        return enumTipoProduto == null ? null : enumTipoProduto.toString();
    }

    @Named("integerToEnum")
    default EnumTipoDocumento integerToEnum(Integer idTipoDocumento){
        return EnumTipoDocumento.getById(idTipoDocumento);
    }
    @Named("enumToInteger")
    default Integer enumToInteger(EnumTipoDocumento enumTipoDocumento){
        return enumTipoDocumento == null ? null : enumTipoDocumento.getId();
    }
}
