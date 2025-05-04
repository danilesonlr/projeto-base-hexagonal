package br.com.base.projeto_base_hexagonal.adapter.outbound.entity.acesso.enums;

public enum AcessoRoleEnum {
    ADMIN("admin"),
    USER("user");

    private String role;

    AcessoRoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
