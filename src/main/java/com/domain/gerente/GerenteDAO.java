package com.domain.gerente;

import com.domain.BaseDAO;
import com.domain.funcionario.FuncionarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GerenteDAO implements BaseDAO<GerenteDTO> {

    private Connection conn;

    public GerenteDAO(){
        this.conn = conn();
    }

    @Override
    public void salvar(GerenteDTO dados) {

        String query = "INSERT INTO gerentes (area, id_funcionario) SELECT ?,  MAX(id) from funcionarios";

        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, dados.getArea());

            pre.execute();
            pre.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<GerenteDTO> obter() {

        List<GerenteDTO> listaGerentes = new ArrayList<>();
        String query = "SELECT f.id, f.nome, f.cpf, f.email, f.salario_base, g.area " +
                        "FROM gerentes g " +
                        "INNER JOIN funcionarios f " +
                        "ON g.id_funcionario = f.id"
                ;

        try {
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet resultado = pre.executeQuery();

            while (resultado.next()){
                Long id = resultado.getLong("id");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String email = resultado.getString("email");
                double salarioBase = resultado.getDouble("salario_base");
                String area = resultado.getString("area");

                listaGerentes.add(new GerenteDTO(area, new FuncionarioDTO(id, nome, cpf, email, salarioBase)));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaGerentes;
    }

    @Override
    public void deletar(Long id) {
        String query = "DELETE FROM gerentes WHERE id_funcionario = ?";

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
    public void atualizar(GerenteDTO dados) {

    }
}
