package com.domain.assistente;

import com.domain.funcionario.Cargo;
import com.domain.funcionario.Funcionario;
import com.domain.funcionario.FuncionarioDTO;

public class Assistente extends Funcionario {

    private String senioridade;

    public Assistente(Long id, String nome, String cpf, String email, double salarioBase, Cargo cargo, String senioridade) {
        super(id, nome, cpf, email, salarioBase, cargo);
        this.senioridade = senioridade;
    }

    public Assistente(FuncionarioDTO dados){
        super(dados.getId(), dados.getNome(), dados.getCpf(), dados.getEmail(), dados.getSalarioBase(), dados.getCargo());
    }

    @Override
    public double calcSalario() {
        return getSalarioBase();
    }

    public String getSenioridade() {
        return senioridade;
    }
}
