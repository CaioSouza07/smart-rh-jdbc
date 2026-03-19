package com.domain.dto;

import java.util.Objects;

public final class FuncionarioDTO {

    private final String nome;
    private final String cpf;
    private final String email;
    private final double salarioBase;

    public FuncionarioDTO(String nome, String cpf, String email, double salarioBase) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.salarioBase = salarioBase;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FuncionarioDTO that = (FuncionarioDTO) o;
        return Double.compare(salarioBase, that.salarioBase) == 0 && Objects.equals(nome, that.nome) && Objects.equals(cpf, that.cpf) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, email, salarioBase);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
