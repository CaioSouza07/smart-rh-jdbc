package com.dao;

import com.domain.funcionario.FuncionarioDTO;

import java.util.List;

public class FuncionarioDAO implements BaseDAO<FuncionarioDTO>{

    @Override
    public void salvar(FuncionarioDTO entity) {

    }

    @Override
    public List<FuncionarioDTO> obter() {
        return List.of();
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public void atualizar(FuncionarioDTO entity) {

    }
}
