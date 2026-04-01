package br.com.estudos.config.infra.domains.dto;

import br.com.estudos.config.infra.enums.EnumRolesUsuario;

public record UsuarioRegistradoDto(String login, EnumRolesUsuario role) {
}
