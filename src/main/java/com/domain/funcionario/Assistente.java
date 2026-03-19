package com.domain.funcionario;

public class Assistente extends Funcionario{

    private String senioridade;

    public Assistente(String nome, String cpf, String email, double salarioBase, String senioridade) {
        super(nome, cpf, email, salarioBase);
        this.senioridade = senioridade;
    }

    @Override
    public double calcSalario() {
        return getSalarioBase();
    }

    public String getSenioridade() {
        return senioridade;
    }
}
