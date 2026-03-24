package com.domain.funcionario;

import java.util.Objects;

public final class FuncionarioDTO {

    private final Long id;
    private final String nome;
    private final String cpf;
    private final String email;
    private final double salarioBase;
    private final Cargo cargo;

    public FuncionarioDTO(Long id, String nome, String cpf, String email, double salarioBase, Cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FuncionarioDTO that = (FuncionarioDTO) o;
        return Double.compare(salarioBase, that.salarioBase) == 0 && Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(cpf, that.cpf) && Objects.equals(email, that.email) && cargo == that.cargo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, email, salarioBase, cargo);
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

    public Long getId() {
        return id;
    }

    public Cargo getCargo() {
        return cargo;
    }
}
