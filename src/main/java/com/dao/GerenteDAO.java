package com.dao;

import com.domain.dto.GerenteDTO;

import java.sql.Connection;
import java.util.List;

public class GerenteDAO implements BaseDAO<GerenteDTO>{

    private Connection conn;

    public GerenteDAO(){
        this.conn = conn();
    }

    @Override
    public void salvar(GerenteDTO entity) {

    }

    @Override
    public List<GerenteDTO> obter() {
        return List.of();
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public void atualizar(GerenteDTO entity) {

    }
}
