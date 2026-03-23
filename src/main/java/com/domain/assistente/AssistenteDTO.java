package com.domain.assistente;

import com.domain.funcionario.FuncionarioDTO;

import java.util.Objects;

public final class AssistenteDTO {

    private final String senioridade;
    private final FuncionarioDTO dadosFuncionario;

    public AssistenteDTO(String senioridade, FuncionarioDTO dadosFuncionario) {
        this.senioridade = senioridade;
        this.dadosFuncionario = dadosFuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AssistenteDTO that = (AssistenteDTO) o;
        return Objects.equals(senioridade, that.senioridade) && Objects.equals(dadosFuncionario, that.dadosFuncionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senioridade, dadosFuncionario);
    }

    public String getSenioridade() {
        return senioridade;
    }

    public FuncionarioDTO getDadosFuncionario() {
        return dadosFuncionario;
    }
}
