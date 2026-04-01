package br.com.estudos.config.infra.domains.dto;

import br.com.estudos.config.infra.enums.EnumRolesUsuario;

public record NovoUsuarioDto(String login, String password, EnumRolesUsuario role, Boolean ativo) {
}
