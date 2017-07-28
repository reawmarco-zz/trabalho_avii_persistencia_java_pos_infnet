package menu;

import controller.FabricanteController;
import model.Fabricante;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MenuFabricante {

    public static void menu() {

        System.out.println("#### MENU Fabricante #### \n");
        System.out.println("1 - Cadastro Fabricante");
        System.out.println("2 - Atualização Cadastro Fabricante");
        System.out.println("3 - Deletar Cadastro Fabricante");
        System.out.println("4 - Listar Todos os Fabricantes");
        System.out.println("5 - Buscar Fabricante");
        System.out.println("6 - Voltar ao menu inicial");

        Scanner s = new Scanner(System.in);

        FabricanteController fabricanteController = new FabricanteController();
        int opcao = s.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("#### MENU Cadastro Fabricante #### \n \n");
                try {
                    fabricanteController.addFabricante(carregaInfoFabricante(false));
                    System.out.println("Cadastro realizado com sucesso! \n");
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro no cadastro do modelo carro, retornando para o menu inicial \n");
                    menu();
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro no cadastro do modelo carro, retornando para o menu inicial \n");
                    menu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                try {
                    listarFabricante(fabricanteController.listFabricante());
                    fabricanteController.atualizaFabricante(carregaInfoFabricante(true));
                    System.out.println("Atualização realizada com sucesso! \n");
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro ao atualizar cadastro do Fabricante, retornando para o menu inicial \n");
                    menu();
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro ao atualizar cadastro do Fabricante, retornando para o menu inicial \n");
                    menu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                deletarFabricante();
                menu();
                break;

            case 4:
                try {
                    listarFabricante(fabricanteController.listFabricante());
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro na pesquisa.Nenhum Fabricante localizado! \n");
                    menu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 5:
                try {
                    listarAcessorio();
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro na pesquisa. Nenhum Fabricante localizado com este nome! \n");
                    menu();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("\n Erro na pesquisa. Nenhum Fabricante localizado com este nome! \n");
                    menu();
                }
                break;
            case 6:
                Start.menuInicial();
                break;

            default:
                System.out.println("Opção errada \n");
                menu();

        }
    }

    private static Fabricante carregaInfoFabricante(boolean alterar) throws Exception {
        Fabricante fabricante = new Fabricante();
        FabricanteController fabricanteController = new FabricanteController();
        Scanner s = new Scanner(System.in);

        if (alterar) {
            listarFabricante(fabricanteController.listFabricante());
            System.out.println("\n ");
            System.out.println("\n Digite o ID do Fabricante que deseja alterar:  ");
            int id = (Integer.valueOf(s.nextLine()));

            fabricante = fabricanteController.buscarFabricante(id);

            if (fabricante.getId() == 0) {
                System.out.println("\n Não foi localizado nenhum Fabricante com este ID.");
                MenuAluguel.menu();
            }

            fabricante.setId(id);
        }

        System.out.println("Digite o Nome: ");
        fabricante.setNome(s.nextLine());


        return fabricante;
    }

    private static void listarFabricante(List<Fabricante> list) {
        System.out.println("#### MENU Resultado Pesquisa Fabricantes #### \n");

        if (list.size() > 0) {
            for (Fabricante fabricante : list) {
                mostraInfoFabricante(fabricante);
            }
        } else {
            System.out.println("\n Nenhum cadastro de Fabricante localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void listarAcessorio() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("#### MENU Busca Fabricante #### \n");

        System.out.println("Digite o ID: ");
        int id = Integer.parseInt(s.nextLine());

        FabricanteController fabricanteController = new FabricanteController();
        Fabricante fabricante = fabricanteController.buscarFabricante(id);

        if (fabricante != null) {
            mostraInfoFabricante(fabricante);
        } else {
            System.out.println("Nenhum cadastro de fabricante com este ID foi localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void deletarFabricante() {
        FabricanteController fabricanteController = new FabricanteController();
        System.out.println("#### MENU Deletar Fabricante #### \n ");

        try {
            listarFabricante(fabricanteController.listFabricante());
            System.out.println("Digite o ID do Fabricante que deseja deletar: ");
            Scanner s = new Scanner(System.in);

            int id = Integer.parseInt(s.nextLine());
            fabricanteController.deletaFabricante(fabricanteController.buscarFabricante(id));

            System.out.println("Fabricante deletado com sucesso!");
            Start.menuInicial();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar o Fabricante! \n");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao deletar o Fabricante! \n");
        }
    }


    public static Fabricante carregaInfoFabricanteParaModeloCarro() throws Exception {
        FabricanteController fabricanteController = new FabricanteController();
        List<Fabricante> listFabricante = fabricanteController.listFabricante();

        if (listFabricante.size() >= 1) {
            for (Fabricante fabricante : listFabricante) {
                mostraInfoFabricante(fabricante);
            }
        }

        System.out.println("\n Digite o ID do Fabricante para adicionar ao carro: ");
        Scanner s = new Scanner(System.in);
        int id = Integer.parseInt(s.nextLine());

        Fabricante fabricante = fabricanteController.buscarFabricante(id);

        if (fabricante.getId() != null) {
            return fabricante;
        } else {
            System.out.println("Nenhum cadastro de Fabricante com este ID localizado! \n ");
        }

        return null;
    }

    private static void carregaListInfoFabricante() throws Exception {

        System.out.println("#### MENU Resultado Pesquisa Fabricante #### \n");
        FabricanteController fabricanteController = new FabricanteController();
        List<Fabricante> list = fabricanteController.listFabricante();

        if (list.size() > 0) {
            for (Fabricante fabricante : list) {
                mostraInfoFabricante(fabricante);
            }
        } else {
            System.out.println("Nenhum cadastro de Fabricante localizado! \n ");
            menu();
        }
    }

    private static void mostraInfoFabricante(Fabricante fabricante) {
        System.out.println("ID: " + fabricante.getId());
        System.out.println("Nome: " + fabricante.getNome());
    }
}