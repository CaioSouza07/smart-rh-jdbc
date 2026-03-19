package com.domain.funcionario;

public class Desenvolvedor extends Funcionario{

    private String linguagem;
    private double bonus;

    public Desenvolvedor(Long id, String nome, String cpf, String email, double salarioBase, String linguagem, double bonus) {
        super(id, nome, cpf, email, salarioBase);
        this.linguagem = linguagem;
        this.bonus = bonus;
    }

    public Desenvolvedor(DesenvolvedorDTO dados){
        super(dados.getNome(), dados.getCpf(), dados.getEmail(), dados.getSalarioBase());
        this.linguagem = dados.getLinguagem();
        this.bonus = dados.getBonus();
    }

    @Override
    public double calcSalario() {
        return getSalarioBase() + bonus;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public double getBonus() {
        return bonus;
    }
}
