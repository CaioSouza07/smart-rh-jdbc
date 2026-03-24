package com.domain.desenvolvedor;

import com.domain.funcionario.Cargo;
import com.domain.funcionario.Funcionario;

public class Desenvolvedor extends Funcionario {

    private String linguagem;
    private double extra;

    public Desenvolvedor(Long id, String nome, String cpf, String email, double salarioBase, Cargo cargo, String linguagem, double extra) {
        super(id, nome, cpf, email, salarioBase, cargo);
        this.linguagem = linguagem;
        this.extra = extra;
    }

    @Override
    public double calcSalario() {
        return getSalarioBase() + extra;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public double getExtra() {
        return extra;
    }
}
