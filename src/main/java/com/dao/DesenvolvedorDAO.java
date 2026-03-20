package com.dao;

import com.domain.dto.DesenvolvedorDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DesenvolvedorDAO implements BaseDAO<DesenvolvedorDTO> {

    private Connection conn;

    DesenvolvedorDAO(){
        this.conn = conn();
    }

    @Override
    public void salvar(DesenvolvedorDTO dados) {

        String query = "INSERT INTO desenvolvedores (linguagem, id_funcionario) SELECT ?, max(id) from funcionarios";

        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, dados.getLinguagem());

            pre.execute();
            pre.close();
            conn.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List obter() {
        List<Object> objects = new java.util.ArrayList<>();
        return objects;
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public void atualizar(DesenvolvedorDTO dados) {

    }
}
