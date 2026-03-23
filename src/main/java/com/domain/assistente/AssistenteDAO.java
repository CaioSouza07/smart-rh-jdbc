package com.domain.assistente;

import com.domain.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AssistenteDAO implements BaseDAO<AssistenteDTO> {

    private Connection conn;

    public AssistenteDAO() {
        this.conn = conn();
    }

    @Override
    public void salvar(AssistenteDTO dados) {

        String query = "INSERT INTO assistentes (senioridade, id_funcionario)   SELECT ?, MAX(id) FROM funcionarios";

        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, dados.getSenioridade());

            pre.execute();
            pre.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<AssistenteDTO> obter() {
        return List.of();
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public void atualizar(AssistenteDTO dados) {

    }
}
