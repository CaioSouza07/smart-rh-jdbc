package com.dao;

import com.domain.dto.FuncionarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioDAO implements BaseDAO<FuncionarioDTO>{

    private Connection conn;

    FuncionarioDAO(){
        this.conn = conn();
    }

    @Override
    public void salvar(FuncionarioDTO dados) {

        String query = "INSERT INTO funcionarios (nome, email, salario_base) VALUES (?, ?, ?)";

        try {
            PreparedStatement pre = conn.prepareStatement(query);

            pre.setString(1, dados.getNome());
            pre.setString(2, dados.getEmail());
            pre.setDouble(3, dados.getSalarioBase());

            pre.execute(query);
            pre.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<FuncionarioDTO> obter() {
        List<FuncionarioDTO> funcionarioDTOS = new java.util.ArrayList<>();
        return funcionarioDTOS;
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public void atualizar(FuncionarioDTO entity) {

    }
}
