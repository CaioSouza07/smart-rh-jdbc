package com.domain.desenvolvedor;

import com.domain.BaseDAO;
import com.domain.funcionario.Cargo;
import com.domain.funcionario.FuncionarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesenvolvedorDAO implements BaseDAO<DesenvolvedorDTO> {

    private Connection conn;

    public DesenvolvedorDAO(){
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
    public List<DesenvolvedorDTO> obter() {

        List<DesenvolvedorDTO> listaDevs = new ArrayList<>();
        String query = "SELECT f.id, f.nome, f.cpf, f.email, f.salario_base, f.cargo, d.linguagem " +
                "FROM desenvolvedores d " +
                "INNER JOIN funcionarios f " +
                "ON d.id_funcionario = f.id";

        try {
            PreparedStatement pre = conn().prepareStatement(query);
            ResultSet resultado = pre.executeQuery();

            while (resultado.next()){
                Long id = resultado.getLong("id");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                String email = resultado.getString("email");
                double salario = resultado.getDouble("salario_base");
                String linguagem = resultado.getString("linguagem");
                Cargo cargo = Cargo.valueOf(resultado.getString("cargo"));

                listaDevs.add(new DesenvolvedorDTO(linguagem, new FuncionarioDTO(id, nome, cpf, email, salario, cargo)));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaDevs;
    }

    @Override
    public void deletar(Long id) {
        String query = "DELETE FROM desenvolvedores WHERE id_funcionario = ?";

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
    public void atualizar(DesenvolvedorDTO dados) {

    }
}
