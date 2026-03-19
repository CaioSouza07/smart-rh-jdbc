package com.dao;

import com.domain.funcionario.Desenvolvedor;
import com.domain.funcionario.DesenvolvedorDTO;

import java.sql.Connection;
import java.util.List;

public class DesenvolvedorDAO implements BaseDAO<DesenvolvedorDTO> {


    @Override
    public void salvar(DesenvolvedorDTO dados) {

        Desenvolvedor desenvolvedor = new Desenvolvedor(dados);

        String query = "INSERT INTO funcionarios ";

    }

    @Override
    public List obter() {
        return List.of();
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public void atualizar(DesenvolvedorDTO dados) {

    }
}
