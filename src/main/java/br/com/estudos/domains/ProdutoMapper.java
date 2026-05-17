package br.com.estudos.domains;

import br.com.estudos.domains.dto.ProdutoDTO;
import br.com.estudos.domains.enums.EnumTipoProduto;
import br.com.estudos.domains.generics.enums.EnumTipoDocumento;
import br.com.estudos.domains.mappers.EnumMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    @Mapping(source = "tipoProduto",target="tipo")
    @Mapping(source = "tipoDocumento", target="tipoDocto")
    Produto toProduto(ProdutoDTO dto);
    List<ProdutoDTO> toListDTO(List<Produto> listaProduto);
    List<Produto> toListProduto(List<ProdutoDTO> dtos);

    default EnumTipoProduto stringToEnum(String valor){
        return EnumTipoProduto.valueOf(valor.toUpperCase());
    }

    default EnumTipoDocumento intToString(Integer idTipoDocumento){
        return EnumTipoDocumento.getById(idTipoDocumento);
    }
}
