package com.domain.dto;

import java.util.Objects;

// aqui caso tivesse utilizando java 16 ou superior estaria usando record para criar essa classe imutavel
public final class DesenvolvedorDTO {


    private final String linguagem;
    private final double extra;
    private final FuncionarioDTO dadosFuncionario;

    public DesenvolvedorDTO(String linguagem, double extra, FuncionarioDTO dadosFuncionario) {
        this.linguagem = linguagem;
        this.extra = extra;
        this.dadosFuncionario = dadosFuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DesenvolvedorDTO that = (DesenvolvedorDTO) o;
        return Double.compare(extra, that.extra) == 0 && Objects.equals(linguagem, that.linguagem) && Objects.equals(dadosFuncionario, that.dadosFuncionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linguagem, extra, dadosFuncionario);
    }

    public FuncionarioDTO getDadosFuncionario() {
        return dadosFuncionario;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public double getExtra() {
        return extra;
    }
}
