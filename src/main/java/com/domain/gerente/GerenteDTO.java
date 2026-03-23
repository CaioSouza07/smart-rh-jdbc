package com.domain.gerente;

import com.domain.funcionario.FuncionarioDTO;

import java.util.Objects;

public final class GerenteDTO {

    private final String area;
    private final FuncionarioDTO dadosFuncionario;

    public GerenteDTO(String area, FuncionarioDTO dadosFuncionario) {
        this.area = area;
        this.dadosFuncionario = dadosFuncionario;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GerenteDTO that = (GerenteDTO) o;
        return Objects.equals(area, that.area) && Objects.equals(dadosFuncionario, that.dadosFuncionario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, dadosFuncionario);
    }

    public String getArea() {
        return area;
    }

    public FuncionarioDTO getDadosFuncionario() {
        return dadosFuncionario;
    }
}
