package com;

import com.domain.assistente.Assistente;
import com.domain.assistente.AssistenteDAO;
import com.domain.assistente.AssistenteDTO;
import com.domain.desenvolvedor.Desenvolvedor;
import com.domain.desenvolvedor.DesenvolvedorDAO;
import com.domain.funcionario.Cargo;
import com.domain.funcionario.FuncionarioDAO;
import com.domain.gerente.Gerente;
import com.domain.gerente.GerenteDAO;
import com.domain.RegraNegocioException;
import com.domain.desenvolvedor.DesenvolvedorDTO;
import com.domain.funcionario.FuncionarioDTO;
import com.domain.gerente.GerenteDTO;
import java.util.List;
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
                        cadastrarFuncionario();
                        break;
                    case 4:
                        calcularSalario();
                        break;
                    case 5:
                        deletarFuncionario();
                        break;
                }

            }catch (RegraNegocioException e){
                System.out.println("Erro: " + e.getMessage());
                System.out.println("Clique ENTER para voltar ao menu...");
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

        FuncionarioDAO funDAO = new FuncionarioDAO();
        List<FuncionarioDTO> listaFuncionarios = funDAO.obter();

        if(listaFuncionarios.isEmpty()){
            System.out.println("Nenhum funcionário cadastrado!");
        }else{
            for(FuncionarioDTO dados : listaFuncionarios){
                System.out.println(
                        "| ID: " + dados.getId() + "\n" +
                                "| Nome: " + dados.getNome() + "\n" +
                                "| CPF: " + dados.getCpf() + "\n" +
                                "| E-mail: " + dados.getEmail() + "\n" +
                                "| Salário base: " + dados.getSalarioBase() + "\n" +
                                "| Cargo: " + dados.getCargo().name() + "\n" +
                                "|" + "-".repeat(20)
                );
            }
        }

    }

    private static void listarFuncionariosFiltro(){

        System.out.println("Digite o numero correspondente a função:");
        System.out.println(
                "1 - GERENTE\n" +
                "2 - DESENVOLVEDOR\n" +
                "3 - ASSISTENTE"
        );
        int numFuncao = leitor.nextInt();



        switch (numFuncao){
            case 1:
                listarGerentes();
                break;
            case 2:
                listarDesenvolvedores();
                break;
            case 3:
                listarAssistentes();
                break;
        }







    }

    public static void listarGerentes(){

        GerenteDAO gerenteDAO = new GerenteDAO();
        List<GerenteDTO> listaGerentes = gerenteDAO.obter();
        if(listaGerentes.isEmpty()){
            System.out.println("Nenhum gerente cadastrado!");
        }else{
            System.out.println("=".repeat(10) + " Lista de Gerentes " + "=".repeat(10));

            for (GerenteDTO dados : listaGerentes){
                System.out.println(
                        "| ID: " + dados.getDadosFuncionario().getId() + "\n" +
                                "| Nome: " + dados.getDadosFuncionario().getNome() + "\n" +
                                "| CPF: " + dados.getDadosFuncionario().getCpf() + "\n" +
                                "| E-mail: " + dados.getDadosFuncionario().getEmail() + "\n" +
                                "| Salário base: " + dados.getDadosFuncionario().getSalarioBase() + "\n" +
                                "| Líder da área: " + dados.getArea() + "\n" +
                                "|" + "-".repeat(20)
                );
            }
        }
    }

    public static void listarDesenvolvedores(){

        DesenvolvedorDAO devDAO = new DesenvolvedorDAO();
        List<DesenvolvedorDTO> listaDevs = devDAO.obter();

        if(listaDevs.isEmpty()){
            System.out.println("Nenhum desenvolvedor cadastrado!");
        }else{
            System.out.println("=".repeat(10) + " Lista de Desenvolvedores " + "=".repeat(10));

            for (DesenvolvedorDTO dados : listaDevs){
                System.out.println(
                        "| ID: " + dados.getDadosFuncionario().getId() + "\n" +
                                "| Nome: " + dados.getDadosFuncionario().getNome() + "\n" +
                                "| CPF: " + dados.getDadosFuncionario().getCpf() + "\n" +
                                "| E-mail: " + dados.getDadosFuncionario().getEmail() + "\n" +
                                "| Salário base: " + dados.getDadosFuncionario().getSalarioBase() + "\n" +
                                "| Linguagem: " + dados.getLinguagem() + "\n" +
                                "|" + "-".repeat(20)
                );
            }
        }

    }

    private static void listarAssistentes(){
        AssistenteDAO assistDAO = new AssistenteDAO();
        List<AssistenteDTO> listaAssist = assistDAO.obter();

        if(listaAssist.isEmpty()){
            System.out.println("Nenhum assistente cadastrado!");
        }else{
            System.out.println("=".repeat(10) + " Lista de Assistentes " + "=".repeat(10));

            for (AssistenteDTO dados : listaAssist){
                System.out.println(
                        "| ID: " + dados.getDadosFuncionario().getId() + "\n" +
                                "| Nome: " + dados.getDadosFuncionario().getNome() + "\n" +
                                "| CPF: " + dados.getDadosFuncionario().getCpf() + "\n" +
                                "| E-mail: " + dados.getDadosFuncionario().getEmail() + "\n" +
                                "| Salário base: " + dados.getDadosFuncionario().getSalarioBase() + "\n" +
                                "| Nível: " + dados.getSenioridade() + "\n" +
                                "|" + "-".repeat(20)
                );
            }
        }

    }

    private static void cadastrarFuncionario(){
        System.out.println("Digite o nome:");
        String nome = leitor.next();

        System.out.println("Digite o CPF:");
        String cpf = leitor.next();

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

        switch (numFuncao){
            case 1:
                salvarGerente(nome, cpf, email, salarioBase);
                break;
            case 2:
                salvarDev(nome, cpf, email, salarioBase);
                break;
            case 3:
                salvarAssist(nome, cpf, email, salarioBase);
                break;
            default:
                System.out.println("Escolha uma opção válida!!!!");
        }


    }

    private static void salvarGerente(String nome, String cpf, String email, double salarioBase){

        System.out.println("Digite a área gerenciada: ");
        String area = leitor.next();

        FuncionarioDTO funDTO = new FuncionarioDTO(null, nome, cpf, email, salarioBase, Cargo.GERENTE);
        GerenteDTO gerenteDTO = new GerenteDTO(area, funDTO);

        FuncionarioDAO funDAO = new FuncionarioDAO();
        funDAO.salvar(funDTO);

        GerenteDAO gerenteDAO = new GerenteDAO();
        gerenteDAO.salvar(gerenteDTO);

        System.out.println("Gerente cadastrado com sucesso!");
        System.out.println("Pressione ENTER para voltar ao menu...");
        leitor.next();

    }

    private static void salvarDev(String nome, String cpf, String email, double salarioBase){
        System.out.println("Digite a linguagem de programação que irá utilizar:");
        String linguagem = leitor.next();

        FuncionarioDTO funDTO = new FuncionarioDTO(null, nome, cpf, email, salarioBase, Cargo.DESENVOLVEDOR);
        DesenvolvedorDTO devDTO = new DesenvolvedorDTO(linguagem, funDTO);

        FuncionarioDAO funDAO = new FuncionarioDAO();
        funDAO.salvar(funDTO);

        DesenvolvedorDAO devDAO = new DesenvolvedorDAO();
        devDAO.salvar(devDTO);

        System.out.println("Desenvolvedor cadastrado com sucesso!");
        System.out.println("Pressione ENTER para voltar ao menu...");
        leitor.next();

    }

    private static void salvarAssist(String nome, String cpf, String email, double salarioBase){
        System.out.println("Digite a senioridade do assistente: ");
        String senioridade = leitor.next();

        FuncionarioDTO funDTO = new FuncionarioDTO(null, nome, cpf, email, salarioBase, Cargo.ASSISTENTE);
        AssistenteDTO assistDTO = new AssistenteDTO(senioridade, funDTO);

        FuncionarioDAO funDAO = new FuncionarioDAO();
        funDAO.salvar(funDTO);

        AssistenteDAO assistDAO = new AssistenteDAO();
        assistDAO.salvar(assistDTO);

        System.out.println("Assistente cadastrado com sucesso!");
        System.out.println("Pressione ENTER para voltar ao menu...");
        leitor.next();

    }

    private static void calcularSalario(){
        System.out.println("Digite o ID do funcionário: ");
        Long id = leitor.nextLong();

        FuncionarioDAO funDAO = new FuncionarioDAO();
        FuncionarioDTO funDTOCalculo = funDAO.findById(id);

        switch (funDTOCalculo.getCargo()){
            case GERENTE:
                salarioGerente(new Gerente(funDTOCalculo));
                break;
            case DESENVOLVEDOR:
                salarioDev(new Desenvolvedor(funDTOCalculo));
                break;
            case ASSISTENTE:
                salarioAssist(new Assistente(funDTOCalculo));
                break;
        }

    }

    private static void salarioGerente(Gerente dados){
        System.out.println("Digite o bonus do gerente: (Ex: 0,3)");
        double bonus = leitor.nextDouble();

        dados.setBonus(bonus);

        double salario = dados.calcSalario();
        System.out.println("O salário é: R$ " + salario);
    }

    private static void salarioDev(Desenvolvedor dados){
        System.out.println("Digite o extra do desenvolvedor: ");
        double extra = leitor.nextDouble();

        dados.setExtra(extra);

        double salario = dados.calcSalario();
        System.out.println("O salário é: R$ " + salario);
    }

    private static void salarioAssist(Assistente dados){
        double salario = dados.calcSalario();
        System.out.println("O salário é: R$ " + salario);
    }

    private static void deletarFuncionario(){
        System.out.println("Digite o ID do funcionário que deseja deletar: ");
        Long id = leitor.nextLong();

        FuncionarioDAO funDAO = new FuncionarioDAO();
        FuncionarioDTO funDTODeletar = funDAO.findById(id);

        switch (funDTODeletar.getCargo()){
            case GERENTE:
                GerenteDAO gerDAO = new GerenteDAO();
                gerDAO.deletar(funDTODeletar.getId());
                break;
            case DESENVOLVEDOR:
                DesenvolvedorDAO devDAO = new DesenvolvedorDAO();
                devDAO.deletar(funDTODeletar.getId());
                break;
            case ASSISTENTE:
                AssistenteDAO assistDAO = new AssistenteDAO();
                assistDAO.deletar(funDTODeletar.getId());
                break;
        }
        funDAO.deletar(funDTODeletar.getId());
    }



}
