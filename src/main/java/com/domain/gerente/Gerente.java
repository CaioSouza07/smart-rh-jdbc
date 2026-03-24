package com.domain.gerente;

import com.domain.funcionario.Cargo;
import com.domain.funcionario.Funcionario;
import com.domain.funcionario.FuncionarioDTO;

public class Gerente extends Funcionario {

    private double bonus;
    private String area;

    public Gerente(Long id, String nome, String cpf, String email, double salarioBase, Cargo cargo, double bonus, String area) {
        super(id, nome, cpf, email, salarioBase, cargo);
        this.bonus = bonus;
        this.area = area;
    }

    public Gerente(FuncionarioDTO dados){
        super(dados.getId(), dados.getNome(), dados.getCpf(), dados.getEmail(), dados.getSalarioBase(), dados.getCargo());
    }


    @Override
    public double calcSalario() {
        return getSalarioBase() + ( bonus * getSalarioBase());
    }

    public double getBonus() {
        return bonus;
    }

    public String getArea() {
        return area;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setArea(String area) {
        this.area = area;
    }
}