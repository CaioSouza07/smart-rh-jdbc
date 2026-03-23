package com.domain.gerente;

import com.domain.funcionario.Funcionario;

public class Gerente extends Funcionario {

    private double bonus;
    private String area;

    public Gerente(Long id, String nome, String cpf, String email, double salarioBase, double bonus, String area) {
        super(id, nome, cpf, email, salarioBase);
        this.bonus = bonus;
        this.area = area;
    }

    @Override
    public double calcSalario() {
        return getSalarioBase() + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public String getArea() {
        return area;
    }
}