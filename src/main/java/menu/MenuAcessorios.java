package menu;

import controller.AcessorioController;
import model.Acessorios;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAcessorios {

    public static void menu() {

        System.out.println("#### MENU Acessorios #### \n");
        System.out.println("1 - Cadastro Acessorio");
        System.out.println("2 - Atualização Cadastro Acessorio");
        System.out.println("3 - Deletar Cadastro Acessorio");
        System.out.println("4 - Listar Todos os Acessorios");
        System.out.println("5 - Buscar Acessorio");
        System.out.println("6 - Voltar ao menu inicial");


        Scanner s = new Scanner(System.in);

        AcessorioController acessorioController = new AcessorioController();
        int opcao = s.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("#### MENU Cadastro Acessorio #### \n \n");
                try {
                    acessorioController.addAcessorios(carregaInfoAcessorio(false));
                    System.out.println("Cadastro realizada com sucesso! \n");
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro no cadastro do acessorio, retornando para o menu inicial \n");
                    menu();
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro no cadastro do acessorio, retornando para o menu inicial \n");
                    menu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                try {
                    listarAcessorios(acessorioController.listAcessorios());
                    acessorioController.atualizaAcessorios(carregaInfoAcessorio(true));
                    System.out.println("Atualização realizada com sucesso! \n");
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro ao atualizar cadastro do acessorio, retornando para o menu inicial \n");
                    menu();
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro ao atualizar cadastro do acessorio, retornando para o menu inicial \n");
                    menu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                deletarAcessorio();
                menu();
                break;

            case 4:
                try {
                    listarAcessorios(acessorioController.listAcessorios());
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro na pesquisa.Nenhum acessorio localizado! \n");
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
                    System.out.println("\n Erro na pesquisa. Nenhum acessorio localizado com este nome! \n");
                    menu();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("\n Erro na pesquisa. Nenhum acessorio localizado com este nome! \n");
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

    private static Acessorios carregaInfoAcessorio(boolean alterar) throws Exception {
        Acessorios acessorios = new Acessorios();
        AcessorioController acessorioController = new AcessorioController();
        Scanner s = new Scanner(System.in);

        if (alterar) {
            listarAcessorios(acessorioController.listAcessorios());
            System.out.println("\n ");
            System.out.println("\n Digite o ID do Acessorio que deseja alterar:  ");
            int id = (Integer.valueOf(s.nextLine()));

            acessorios = acessorioController.buscarAcessorios(id);

            if (acessorios.getId() == 0) {
                System.out.println("\n Não foi localizado nenhum acessorio com este ID.");
                MenuAluguel.menu();
            }

            acessorios.setId(id);
        }

        System.out.println("Digite a Descrição: ");
        acessorios.setDescricao(s.nextLine());


        return acessorios;
    }

    private static void listarAcessorios(List<Acessorios> list) {
        System.out.println("#### MENU Resultado Pesquisa Acessorios #### \n");

        if (list.size() > 0) {
            for (Acessorios acessorios : list) {
                mostraInfoAcessorios(acessorios);
            }
        } else {
            System.out.println("\n Nenhum cadastro de Acessorio localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void listarAcessorio() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("#### MENU Busca Acessorio #### \n");

        System.out.println("Digite o ID: ");
        int id = Integer.parseInt(s.nextLine());

        AcessorioController acessorioController = new AcessorioController();
        Acessorios acessorios = acessorioController.buscarAcessorios(id);

        if (acessorios != null) {
            mostraInfoAcessorios(acessorios);
        } else {
            System.out.println("Nenhum cadastro de acessorio com este ID foi localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void deletarAcessorio() {
        AcessorioController acessorioController = new AcessorioController();
        System.out.println("#### MENU Deletar Acessorio #### \n ");

        try {
            listarAcessorios(acessorioController.listAcessorios());
            System.out.println("Digite o ID do acessorio que deseja deletar: ");
            Scanner s = new Scanner(System.in);

            int id = Integer.parseInt(s.nextLine());
            acessorioController.deletaAcessorios(acessorioController.buscarAcessorios(id));

            System.out.println("Acessorio deletado com sucesso!");
            Start.menuInicial();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar o Acessorio! \n");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao deletar o Acessorio! \n");
        }
    }


    public static Acessorios carregaInfoAcessorioParaCarro() throws Exception {
        AcessorioController acessorioController = new AcessorioController();
        List<Acessorios> listAcessorios = acessorioController.listAcessorios();

        if (listAcessorios.size() >= 1) {
            for (Acessorios acessorios : listAcessorios) {
                mostraInfoAcessorios(acessorios);
            }
        }

        System.out.println("\n Digite o ID do acessorio para adicionar ao carro: ");
        Scanner s = new Scanner(System.in);
        int id = Integer.parseInt(s.nextLine());

        Acessorios acessorios = acessorioController.buscarAcessorios(id);

        if (acessorios.getId() != null) {
            return acessorios;
        } else {
            System.out.println("Nenhum cadastro de acessorio com este ID localizado! \n ");
        }

        return null;
    }

    private static void carregaListInfoAcessorio() throws Exception {

        System.out.println("#### MENU Resultado Pesquisa Acessorio #### \n");
        AcessorioController acessorioController = new AcessorioController();
        List<Acessorios> list = acessorioController.listAcessorios();

        if (list.size() > 0) {
            for (Acessorios acessorios : list) {
                mostraInfoAcessorios(acessorios);
            }
        } else {
            System.out.println("Nenhum cadastro de Acessorio localizado! \n ");
            menu();
        }
    }

    private static void mostraInfoAcessorios(Acessorios acessorios) {
        System.out.println("ID: " + acessorios.getId());
        System.out.println("Descricao: " + acessorios.getDescricao());
        System.out.println("\n ######################################################## \n ");
    }
}
