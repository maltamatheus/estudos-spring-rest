package br.com.estudos.config.infra.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EnumRolesUsuario {
    ADMIN("admin"),
    AUDITOR("auditor"),
    VIEWER("viewer");

    private String role;
}
