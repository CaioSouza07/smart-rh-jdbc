package com.domain.funcionario;

import com.domain.BaseDAO;
import com.domain.RegraNegocioException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioDAO implements BaseDAO<FuncionarioDTO> {

    private Connection conn;

    public FuncionarioDAO(){
        this.conn = conn();
    }

    @Override
    public void salvar(FuncionarioDTO dados) {

        String query = "INSERT INTO funcionarios (nome, cpf, email, salario_base, cargo) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement pre = conn.prepareStatement(query);

            pre.setString(1, dados.getNome());
            pre.setString(2, dados.getCpf());
            pre.setString(3, dados.getEmail());
            pre.setDouble(4, dados.getSalarioBase());
            pre.setString(5, dados.getCargo().name());

            pre.execute();
            pre.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<FuncionarioDTO> obter() {

        List<FuncionarioDTO> listaFuncionarios = new java.util.ArrayList<>();
        String query = "SELECT * FROM funcionarios";

        try {
            PreparedStatement pre = conn.prepareStatement(query);
            ResultSet resultado = pre.executeQuery();

            while (resultado.next()){

                Long id = resultado.getLong("id");
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                double salarioBase = resultado.getDouble("salario_base");
                String cpf = resultado.getString("cpf");
                Cargo cargo = Cargo.valueOf(resultado.getString("cargo"));

                listaFuncionarios.add(new FuncionarioDTO(id, nome, cpf, email, salarioBase, cargo));

            }

            pre.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaFuncionarios;
    }

    @Override
    public void deletar(Long id) {
        String query = "DELETE FROM funcionarios WHERE id = ?";

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
    public void atualizar(FuncionarioDTO entity) {

    }

    public FuncionarioDTO findById(Long id){
        String query = "SELECT * FROM funcionarios WHERE id = ?";

        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setLong(1, id);
            ResultSet resultado = pre.executeQuery();

            if(resultado.next()){
                do{

                    Long id_funcionario = resultado.getLong("id");
                    String nome = resultado.getString("nome");
                    String cpf = resultado.getString("cpf");
                    String email = resultado.getString("email");
                    double salarioBase = resultado.getDouble("salario_base");
                    Cargo cargo = Cargo.valueOf(resultado.getString("cargo"));

                    FuncionarioDTO dto = new FuncionarioDTO(id_funcionario, nome, cpf, email, salarioBase, cargo);

                    return dto;
                }while(resultado.next());
            }else{
                throw new RegraNegocioException("Funcionário com ID não encontrado!");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
