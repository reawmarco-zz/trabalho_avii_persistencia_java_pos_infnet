package menu;

import controller.MotoristaController;
import model.ESexo;
import model.Motorista;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MenuMotorista {

    public static void menu() {
        System.out.println("#### MENU Motorista #### \n");
        System.out.println("1 - Cadastro Motorista");
        System.out.println("2 - Atualização Cadastro Motorista");
        System.out.println("3 - Deletar Cadastro Motorista");
        System.out.println("4 - Listar Todos os Motorista");
        System.out.println("5 - Buscar Motorista por nome");


        Scanner s = new Scanner(System.in);
        MotoristaController motoristaController = new MotoristaController();
        int opcao = s.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("\n #### MENU Cadastro Motorista #### \n \n");
                try {
                    motoristaController.addMotorista(carregaInfoMotorista(false));
                    System.out.println("Cadastro realizada com sucesso! \n");
                    Start.menuInicial();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro no cadastro do motorista, retornando para o menu inicial \n");
                    Start.menuInicial();
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Erro no cadastro do motorista, retornando para o menu inicial \n");
                    Start.menuInicial();
                }
                break;

            case 2:
                try {
                    listarMotoristas(motoristaController.listMotorista());
                    motoristaController.atualizaMotorista(carregaInfoMotorista(true));
                    System.out.println("Atualização realizada com sucesso! \n");
                    Start.menuInicial();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro ao atualizar cadastro do motorista, retornando para o menu inicial \n");
                    Start.menuInicial();
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Erro ao atualizar cadastro do motorista, retornando para o menu inicial \n");
                    Start.menuInicial();
                }
                break;

            case 3:
                deletarMotorista();
                Start.menuInicial();
                break;

            case 4:
                try {
                    listarMotoristas(motoristaController.listMotorista());
                    Start.menuInicial();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro na pesquisa.Nenhum Motorista localizado! \n");
                    Start.menuInicial();
                }
                break;

            case 5:
                try {
                    listaMotorista();
                    Start.menuInicial();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro na pesquisa. Nenhum Motorista localizado com este nome! \n");
                    Start.menuInicial();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Erro na pesquisa. Nenhum Motorista localizado com este nome! \n");
                    Start.menuInicial();
                }
                break;

            default:
                System.out.println("Opção errada, voltando para o menu inicial \n");
                Start.menuInicial();

        }
    }

    private static Motorista carregaInfoMotorista(boolean alterar) throws ParseException, SQLException {
        Motorista motorista = new Motorista();
        MotoristaController motoristaController = new MotoristaController();
        Scanner s = new Scanner(System.in);

        if (alterar) {
            listarMotoristas(motoristaController.listMotorista());
            System.out.println("\n ");
            System.out.println("\n Digite o ID do Motorista que deseja alterar:  ");
            int id = (Integer.valueOf(s.nextLine()));

            motorista = motoristaController.buscarMotorista(id);

            if (motorista.getId() == 0) {
                System.out.println("Não foi localizado nenhum motorista com este ID.");
                MenuAluguel.menu();
            }

            motorista.setId(id);
        }

        System.out.println("Digite o nome: ");
        motorista.setNome(s.nextLine());

        System.out.println("Digite a data de nascimento: dd/MM/yyyy ");
        motorista.setDataNascimento(s.nextLine());

        System.out.println("Digite o número da CNH: ");
        motorista.setNumCNH(s.nextLine());

        System.out.println("Digite o sexo: 1:Masculino / 2:Feminino ");
        int opcao = s.nextInt();

        switch (opcao) {
            case 1:
                motorista.setSexo(ESexo.MASCULINO);
                break;
            case 2:
                motorista.setSexo(ESexo.FEMININO);
                break;
            default:
                System.out.println("Opção errada! Sexo Masculino setado");
                motorista.setSexo(ESexo.MASCULINO);
        }

        System.out.println("Digite o cpf (este valor é usado para localizar o Motorista): ");
        motorista.setCpf(s.nextLine());


        return motorista;
    }

    private static void listarMotoristas(List<Motorista> list) {
        System.out.println("\n #### MENU Resultado Pesquisa Motoristas #### \n");

        if (list.size() > 0) {
            for (Motorista motorista : list) {
                mostraInfoMotorista(motorista);
            }
        } else {
            System.out.println("Nenhum cadastro de Motorista localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void listaMotorista() throws SQLException {
        Scanner s = new Scanner(System.in);
        System.out.println("\n #### MENU Busca Motorista #### \n");
        System.out.println("Digite o nome: ");
        String nome = s.nextLine();

        MotoristaController motoristaController = new MotoristaController();
        Motorista motorista = motoristaController.buscarMotorista(nome);

        if (motorista != null) {
            mostraInfoMotorista(motorista);
        } else {
            System.out.println("Nenhum cadastro de motorista com este nome localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void deletarMotorista() {
        MotoristaController motoristaController = new MotoristaController();
        System.out.println("\n #### MENU Deletar Motorista #### \n ");

        try {
            listarMotoristas(motoristaController.listMotorista());
            System.out.println("Digite o número da CNH do motorista que deseja deletar: ");
            Scanner s = new Scanner(System.in);

            String cnh = s.nextLine();

            motoristaController.deleteMotorista(cnh);

            System.out.println("Motorista deletado com sucesso!");
            Start.menuInicial();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar o motorista! \n");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao deletar o motorista! \n");
        }
    }

    public static String carregaInfoMotoristaParaAluguel() throws SQLException {
        MotoristaController motoristaController =  new MotoristaController();
        listarMotoristas(motoristaController.listMotorista());

        Scanner s = new Scanner(System.in);
        System.out.println("\n #### MENU Busca Motorista #### \n");
        System.out.println("Digite o ID: ");
        int id = Integer.parseInt(s.nextLine());

        Motorista motorista = motoristaController.buscarMotorista(id);

        if (motorista.getNumCNH() != null) {
            mostraInfoMotorista(motorista);
        } else {
            System.out.println("Nenhum cadastro de motorista com este nome localizado! \n ");
            carregaListInfoMotorista();
        }

        return motorista.getNumCNH();
    }

    private static void carregaListInfoMotorista() throws SQLException {

        System.out.println("\n #### MENU Resultado Pesquisa Motoristas #### \n");
        MotoristaController motoristaController = new MotoristaController();
        List<Motorista> list = motoristaController.listMotorista();

        if (list.size() > 0) {
            for (Motorista motorista : list) {
                mostraInfoMotorista(motorista);
            }
        } else {
            System.out.println("Nenhum cadastro de Motorista localizado! \n ");
            System.out.println("Cadastre um Motorista para continuar o aluguel... Você será direcionado para o cadastro de Motoristas.");
            menu();
        }
    }

    private static void mostraInfoMotorista(Motorista motorista){
        System.out.println("ID " +  motorista.getId());
        System.out.println("Nome: " + motorista.getNome());
        System.out.println("CPF: " + motorista.getCpf());
        System.out.println("Num CNH: " + motorista.getNumCNH());
        System.out.println("Data Nascimento: " + motorista.getDataNascimento());
        System.out.println("Sexo: " + motorista.getSexo());
        System.out.println("\n \n ");
    }
}