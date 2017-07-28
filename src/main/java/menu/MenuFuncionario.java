package menu;

import controller.FuncionarioController;
import model.ESexo;
import model.Funcionario;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MenuFuncionario {


    public static void menu() {
        System.out.println("#### MENU Funcionario #### \n ");
        System.out.println("1 - Cadastro Funcionário");
        System.out.println("2 - Atualização Cadastro Funcionário");
        System.out.println("3 - Deletar Cadastro Funcionário");
        System.out.println("4 - Listar Todos os Funcionários");
        System.out.println("5 - Buscar Funcionário por nome");

        Scanner s = new Scanner(System.in);
        FuncionarioController funcionarioController = new FuncionarioController();
        int opcao = s.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("#### MENU Cadastro Funcionário #### \n \n");
                try {
                    funcionarioController.addFuncionario(carregaInfoFuncionario(false));
                    System.out.println("Cadastro realizada com sucesso! \n");
                    Start.menuInicial();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro no cadastro do funcionario, retornando para o menu inicial \n");
                    Start.menuInicial();
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Erro no cadastro do funcionario, retornando para o menu inicial \n");
                    Start.menuInicial();
                }
                break;

            case 2:
                try {
                    listarFuncionarios(funcionarioController.listFuncionario());
                    funcionarioController.atualizaFuncionario(carregaInfoFuncionario(true));
                    System.out.println("Atualização realizada com sucesso! \n");
                    Start.menuInicial();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro ao atualizar cadastro do funcionario, retornando para o menu inicial \n");
                    Start.menuInicial();
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Erro ao atualizar cadastro do funcionario, retornando para o menu inicial \n");
                    Start.menuInicial();
                }
                break;

            case 3:
                deletarFuncionario();
                Start.menuInicial();
                break;

            case 4:
                try {
                    listarFuncionarios(funcionarioController.listFuncionario());
                    Start.menuInicial();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro na pesquisa.Nenhum funcionário localizado! \n");
                    Start.menuInicial();
                }
                break;

            case 5:
                try {
                    listaFuncionario();
                    Start.menuInicial();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro na pesquisa. Nenhum Funcionario localizado com este nome! \n");
                    Start.menuInicial();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Erro na pesquisa. Nenhum Funcionario localizado com este nome! \n");
                    Start.menuInicial();
                }
                break;

            default:
                System.out.println("Opção errada, voltando para o menu inicial \n");
                Start.menuInicial();

        }
    }

    private static Funcionario carregaInfoFuncionario(boolean alterar) throws ParseException, SQLException {
        Funcionario funcionario = new Funcionario();
        FuncionarioController funcionarioController = new FuncionarioController();
        Scanner s = new Scanner(System.in);

        if (alterar) {
            listarFuncionarios(funcionarioController.listFuncionario());
            System.out.println("\n ");
            System.out.println("\n Digite o ID do Funcionário que deseja alterar:  ");
            int id = (Integer.valueOf(s.nextLine()));

            funcionario = funcionarioController.buscarFuncionario(id);

            if (funcionario.getId() == 0) {
                System.out.println("Não foi localizado nenhum funcionário com este ID.");
                MenuAluguel.menu();
            }

            funcionario.setId(id);
        }

        System.out.println("Digite o nome: ");
        funcionario.setNome(s.nextLine());

        System.out.println("Digite a data de nascimento: dd/MM/yyyy ");
        funcionario.setDataNascimento(s.nextLine());

       System.out.println("Digite o número da matrícula: ");
        funcionario.setNumMatricula(s.nextLine());

        System.out.println("Digite o cpf: ");
        funcionario.setCpf(s.nextLine());

        System.out.println("Digite o sexo: 1:Masculino / 2:Feminino ");
        int opcao = s.nextInt();

        switch (opcao) {
            case 1:
                funcionario.setSexo(ESexo.MASCULINO);
                break;
            case 2:
                funcionario.setSexo(ESexo.FEMININO);
                break;
            default:
                System.out.println("Opção errada! Sexo Masculino setado");
                funcionario.setSexo(ESexo.MASCULINO);
        }

        return funcionario;
    }

    private static void listarFuncionarios(List<Funcionario> list) {
        System.out.println("#### MENU Resultado Pesquisa Funcionários #### \n");

        if (list.size() > 0) {
            for (Funcionario funcionario : list) {
                mostrarInfoFuncionario(funcionario);
            }
        } else {
            System.out.println("Nenhum cadastro de funcionário localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void listaFuncionario() throws SQLException {
        Scanner s = new Scanner(System.in);
        System.out.println("#### MENU Busca Funcionário #### \n");
        System.out.println("Digite o nome: ");
        String nome = s.nextLine();

        FuncionarioController funcionarioController = new FuncionarioController();
        Funcionario funcionario = funcionarioController.buscarFuncionario(nome);

        if (funcionario != null) {
            mostrarInfoFuncionario(funcionario);
        } else {
            System.out.println("Nenhum cadastro de funcionário com este nome localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void deletarFuncionario() {
        FuncionarioController funcionarioController = new FuncionarioController();
        System.out.println("#### MENU Deletar Funcionário #### \n ");

        try {
            listarFuncionarios(funcionarioController.listFuncionario());
            System.out.println("Digite o número de matrícula do Funcionário que deseja deletar: ");
            Scanner s = new Scanner(System.in);
            String numMatricula = s.nextLine();
            funcionarioController.deleteFuncionario(numMatricula);
            System.out.println("Funcionário deletado com sucesso!");
            Start.menuInicial();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar o funcionário! \n");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao deletar o funcionário! \n");
        }
    }

    private static void mostrarInfoFuncionario(Funcionario funcionario) {
        System.out.println("ID: " + funcionario.getId());
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("CPF: " + funcionario.getCpf());
        System.out.println("Num Matrícula: " + funcionario.getNumMatricula());
        System.out.println("Data Nascimento: " + funcionario.getDataNascimento());
        System.out.println("Sexo: " + funcionario.getSexo());
    }
}