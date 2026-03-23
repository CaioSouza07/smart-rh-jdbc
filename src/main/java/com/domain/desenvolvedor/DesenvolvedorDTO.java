package com.domain.desenvolvedor;

import com.domain.funcionario.FuncionarioDTO;

import java.util.Objects;

// aqui caso tivesse utilizando java 16 ou superior estaria usando record para criar essa classe imutavel
public final class DesenvolvedorDTO {


    private final String linguagem;
    private final FuncionarioDTO dadosFuncionario;

    public DesenvolvedorDTO(String linguagem, FuncionarioDTO dadosFuncionario) {
        this.linguagem = linguagem;
        this.dadosFuncionario = dadosFuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DesenvolvedorDTO that = (DesenvolvedorDTO) o;
        return Objects.equals(linguagem, that.linguagem) && Objects.equals(dadosFuncionario, that.dadosFuncionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linguagem, dadosFuncionario);
    }

    public FuncionarioDTO getDadosFuncionario() {
        return dadosFuncionario;
    }

    public String getLinguagem() {
        return linguagem;
    }

}
