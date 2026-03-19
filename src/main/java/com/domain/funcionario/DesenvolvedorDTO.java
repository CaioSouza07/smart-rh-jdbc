package com.domain.funcionario;

import java.util.Objects;

// aqui caso tivesse utilizando java 16 ou superior estaria usando record para criar essa classe imutavel
public final class DesenvolvedorDTO {

    private final String nome;
    private final String cpf;
    private final String email;
    private final double salarioBase;
    private final String linguagem;
    private final double bonus;

    public DesenvolvedorDTO(String nome, String cpf, String email, double salarioBase, String linguagem, double bonus) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.salarioBase = salarioBase;
        this.linguagem = linguagem;
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DesenvolvedorDTO that = (DesenvolvedorDTO) o;
        return Double.compare(salarioBase, that.salarioBase) == 0 && Double.compare(bonus, that.bonus) == 0 && Objects.equals(nome, that.nome) && Objects.equals(cpf, that.cpf) && Objects.equals(email, that.email) && Objects.equals(linguagem, that.linguagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, email, salarioBase, linguagem, bonus);
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

    public String getLinguagem() {
        return linguagem;
    }

    public double getBonus() {
        return bonus;
    }
}
