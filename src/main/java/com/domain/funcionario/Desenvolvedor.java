package com.domain.funcionario;

import com.domain.dto.DesenvolvedorDTO;

public class Desenvolvedor extends Funcionario{

    private String linguagem;
    private double extra;

    public Desenvolvedor(Long id, String nome, String cpf, String email, double salarioBase, String linguagem, double extra) {
        super(id, nome, cpf, email, salarioBase);
        this.linguagem = linguagem;
        this.extra = extra;
    }

    public Desenvolvedor(DesenvolvedorDTO dados){
        super(dados.getDadosFuncionario().getNome(), dados.getDadosFuncionario().getCpf()
                , dados.getDadosFuncionario().getEmail(), dados.getDadosFuncionario().getSalarioBase());
        this.linguagem = dados.getLinguagem();
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
