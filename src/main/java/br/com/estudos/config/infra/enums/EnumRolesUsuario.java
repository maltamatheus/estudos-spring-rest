package br.com.estudos.config.infra.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
public enum EnumRolesUsuario {
    ADMIN("ADMIN"),
    BLACK("BLACK"),
    GOLD("GOLD");

    private String role;

    public String getRole(){
        log.info("A role escolhida foi {}",this.role);
        return this.role;
    }
}
