package com.domain.funcionario;

import java.util.Objects;

public abstract class Funcionario {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private double salarioBase;

    public Funcionario(Long id, String nome, String cpf, String email, double salarioBase) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.salarioBase = salarioBase;
    }

    public Funcionario(String nome, String cpf, String email, double salarioBase) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.salarioBase = salarioBase;
    }

    public abstract double calcSalario();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id='" + id + '\'' +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", salarioBase=" + salarioBase +
                '}';
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
