package com.domain.gerente;

import com.domain.funcionario.FuncionarioDTO;

import java.util.Objects;

public final class GerenteDTO {

    private final FuncionarioDTO dadosFuncionario;

    public GerenteDTO(FuncionarioDTO dadosFuncionario) {
        this.dadosFuncionario = dadosFuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GerenteDTO that = (GerenteDTO) o;
        return Objects.equals(dadosFuncionario, that.dadosFuncionario);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dadosFuncionario);
    }

    public FuncionarioDTO getDadosFuncionario() {
        return dadosFuncionario;
    }
}
