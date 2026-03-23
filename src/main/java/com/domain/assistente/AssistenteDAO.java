package com.domain.assistente;

import com.domain.BaseDAO;
import com.domain.funcionario.FuncionarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

        List<AssistenteDTO> listaAssist = new ArrayList<>();
        String query = "SELECT f.id, f.nome, f.cpf, f.email, f.salario_base, a.senioridade " +
                "FROM assistentes a " +
                "INNER JOIN funcionarios f " +
                "ON a.id_funcionario = f.id";

        try {
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet resultado = pre.executeQuery();

            while (resultado.next()){
                Long id = resultado.getLong("id");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String email = resultado.getString("email");
                double salarioBase = resultado.getDouble("salario_base");
                String senioridade = resultado.getString("senioridade");

                listaAssist.add(new AssistenteDTO(senioridade, new FuncionarioDTO(id, nome, cpf, email, salarioBase)));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaAssist;
    }

    @Override
    public void deletar(Long id) {
        String query = "DELETE FROM assistentes WHERE id_funcionario = ?";

        try {
            PreparedStatement pre = conn().prepareStatement(query);
            pre.setLong(1, id);

            pre.execute();
            pre.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizar(AssistenteDTO dados) {

    }
}
