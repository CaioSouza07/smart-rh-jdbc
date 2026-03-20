package com;

import com.dao.DesenvolvedorDAO;
import com.domain.RegraNegocioException;

import java.util.Scanner;

public class SmartrhApplication {

    private static Scanner leitor = new Scanner(System.in).useDelimiter("\n");

    public static void main( String[] args ) {

        int opcao = exibirMenu();

        while (opcao != 6){

            try{

                switch (opcao){
                    case 1:
                        listarFuncionarios();
                        break;
                    case 2:
                        listarFuncionariosFiltro();
                        break;
                    case 3:
                        // aqui vou cadastrar um funcionario
                        break;
                    case 4:
                        // aqui vou calcular o salario do funcionario
                        break;
                    case 5:
                        // aqui vou deletar um funcionario
                        break;
                }

            }catch (RegraNegocioException e){
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Clique qualquer tecla para voltar ao menu...");
                leitor.next();
            }
            opcao = exibirMenu();
        }
        System.out.println("Encerrando o programa...");
    }

    private static int exibirMenu(){
        System.out.println("=".repeat(10) +
                " SmartRH - Escolha uma opção: " + "=".repeat(10) + "\n" +
                "1 - Listar funcionários\n" +
                "2 - Listar funcionários (filtro)\n" +
                "3 - Cadastrar um funcionário\n" +
                "4 - Calculo salário funcionário\n" +
                "5 - Deletar funcionário\n" +
                "6 - Sair" +
                "");
        return leitor.nextInt();
    }

    private static void listarFuncionarios(){
        System.out.println("=".repeat(10) + " Lista de Funcionários " + "=".repeat(10));
    }

    private static void listarFuncionariosFiltro(){
        System.out.println("=".repeat(10) + " Lista de Funcionários (Filtro) " + "=".repeat(10));
    }

    private static void cadastrarFuncionario(){
        System.out.println("Digite o nome:");
        String nome = leitor.next();

        System.out.println("Digite o e-mail:");
        String email = leitor.next();

        System.out.println("Digite o salário base:");
        double salarioBase = leitor.nextDouble();

        System.out.println("Digite o numero correspondente a função:");
        System.out.println(
                "1 - GERENTE\n" +
                "2 - DESENVOLVEDOR\n" +
                "3 - ASSISTENTE" +
                "");
        int numFuncao = leitor.nextInt();



    }





}
