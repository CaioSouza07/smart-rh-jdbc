package com.domain.funcionario;

public class Gerente extends Funcionario{

    private double bonus;

    public Gerente(Long id, String nome, String cpf, String email, double salarioBase, double bonus) {
        super(id, nome, cpf, email, salarioBase);
        this.bonus = bonus;
    }

    @Override
    public double calcSalario() {
        return getSalarioBase() + bonus;
    }

    public double getBonus() {
        return bonus;
    }
}