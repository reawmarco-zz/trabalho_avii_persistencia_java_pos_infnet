package menu;

import controller.ModeloCarroController;
import model.ECategoria;
import model.ModeloCarro;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class MenuModeloCarro {

    public static void menu() {

        System.out.println("\n #### MENU Modelo Carro #### \n");
        System.out.println("1 - Cadastro Modelo Carro");
        System.out.println("2 - Atualização Cadastro Modelo Carro");
        System.out.println("3 - Deletar Cadastro Modelo Carro");
        System.out.println("4 - Listar Todos os Modelo Carros");
        System.out.println("5 - Buscar Modelo Carro");
        System.out.println("6 - Adiciona Fabricante");
        System.out.println("7 - Adiciona Categoria");
        System.out.println("8 - Voltar ao menu inicial");

        Scanner s = new Scanner(System.in);

        ModeloCarroController modeloCarroController = new ModeloCarroController();
        int opcao = s.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("\n #### MENU Cadastro Modelo Carro #### \n \n");
                try {
                    modeloCarroController.addModeloCarro(carregaInfoModeloCarro(false));
                    System.out.println("Cadastro realizado com sucesso! \n");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro no cadastro do modelo carro, retornando para o menu inicial \n");
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro no cadastro do modelo carro, retornando para o menu inicial \n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu();
                break;

            case 2:
                try {
                    listarModeloCarro(modeloCarroController.listModeloCarro());
                    modeloCarroController.atualizaModeloCarro(carregaInfoModeloCarro(true));
                    System.out.println("Atualização realizada com sucesso! \n");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro ao atualizar cadastro do Modelo Carro, retornando para o menu inicial \n");
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro ao atualizar cadastro do Modelo Carro, retornando para o menu inicial \n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu();
                break;

            case 3:
                deletarModeloCarro();
                menu();
                break;

            case 4:
                try {
                    listarModeloCarro(modeloCarroController.listModeloCarro());
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro na pesquisa.Nenhum Modelo Carro localizado! \n");
                    menu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu();
                break;

            case 5:
                try {
                    listarModeloCarro();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("\n Erro na pesquisa. Nenhum Modelo Carro localizado com este nome! \n");
                    menu();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("\n Erro na pesquisa. Nenhum Modelo Carro localizado com este nome! \n");
                    menu();
                }
                menu();
                break;
            case 6:
                try {
                    addFabricante();
                    menu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu();
                break;
            case 7:
                try {
                    addCategoria();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu();
                break;
            case 8:
                Start.menuInicial();
                break;

            default:
                System.out.println("Opção errada \n");
                menu();

        }
    }

    private static ModeloCarro carregaInfoModeloCarro(boolean alterar) throws Exception {
        ModeloCarro modeloCarro = new ModeloCarro();
        ModeloCarroController modeloCarroController = new ModeloCarroController();
        Scanner s = new Scanner(System.in);

        if (alterar) {
            listarModeloCarro(modeloCarroController.listModeloCarro());
            System.out.println("\n ");
            System.out.println("\n Digite o ID do Modelo Carro que deseja alterar:  ");
            int id = (Integer.valueOf(s.nextLine()));

            modeloCarro = modeloCarroController.buscarModeloCarro(id);

            if (modeloCarro.getId() == 0) {
                System.out.println("\n Não foi localizado nenhum Modelo Carro com este ID.");
                MenuAluguel.menu();
            }

            modeloCarro.setId(id);
        }

        System.out.println("Digite a Descrição: ");
        modeloCarro.setDescricao(s.nextLine());


        return modeloCarro;
    }

    private static void listarModeloCarro(List<ModeloCarro> list) {
        System.out.println("\n #### MENU Resultado Pesquisa Modelo Carros #### \n");

        if (list.size() > 0) {
            for (ModeloCarro modeloCarro : list) {
                mostraInfoModeloCarro(modeloCarro);
            }
        } else {
            System.out.println("\n Nenhum cadastro de Modelo Carro localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void listarModeloCarro() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("\n #### MENU Busca Modelo Carro #### \n");

        System.out.println("Digite o ID: ");
        int id = Integer.parseInt(s.nextLine());

        ModeloCarroController modeloCarroController = new ModeloCarroController();
        ModeloCarro acessorios = modeloCarroController.buscarModeloCarro(id);

        if (acessorios != null) {
            mostraInfoModeloCarro(acessorios);
        } else {
            System.out.println("Nenhum cadastro de carro com este ID foi localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void deletarModeloCarro() {
        ModeloCarroController modeloCarroController = new ModeloCarroController();
        System.out.println("#### MENU Deletar Modelo Carro #### \n ");

        try {
            listarModeloCarro(modeloCarroController.listModeloCarro());
            System.out.println("Digite o ID do Modelo Carro que deseja deletar: ");
            Scanner s = new Scanner(System.in);

            int id = Integer.parseInt(s.nextLine());
            modeloCarroController.deletaModeloCarro(modeloCarroController.buscarModeloCarro(id));

            System.out.println("Modelo Carro deletado com sucesso!");
            Start.menuInicial();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar o Modelo Carro! \n");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao deletar o Modelo Carro! \n");
        }
    }


    public static ModeloCarro carregaInfoModeloCarroParaCarro() throws Exception {
        ModeloCarroController modeloCarroController = new ModeloCarroController();
        List<ModeloCarro> listModeloCarro = modeloCarroController.listModeloCarro();

        if (listModeloCarro.size() >= 1) {
            for (ModeloCarro acessorios : listModeloCarro) {
                mostraInfoModeloCarro(acessorios);
            }
        }

        System.out.println("\n Digite o ID do Modelo Carro para adicionar ao carro: ");
        Scanner s = new Scanner(System.in);
        int id = Integer.parseInt(s.nextLine());

        ModeloCarro acessorios = modeloCarroController.buscarModeloCarro(id);

        if (acessorios.getId() != null) {
            return acessorios;
        } else {
            System.out.println("Nenhum cadastro de Modelo Carro com este ID localizado! \n ");
        }

        return null;
    }

    private static void carregaListInfoModeloCarro() throws Exception {

        System.out.println("#### MENU Resultado Pesquisa Modelo Carro #### \n");
        ModeloCarroController modeloCarroController = new ModeloCarroController();
        List<ModeloCarro> list = modeloCarroController.listModeloCarro();

        if (list.size() > 0) {
            for (ModeloCarro acessorios : list) {
                mostraInfoModeloCarro(acessorios);
            }
        } else {
            System.out.println("Nenhum cadastro de Modelo Carro localizado! \n ");
            menu();
        }
    }

    private static void addFabricante() throws Exception {
        ModeloCarroController modeloCarroController = new ModeloCarroController();
        ModeloCarro modeloCarro;

        listarModeloCarro(modeloCarroController.listModeloCarro());

        Scanner s = new Scanner(System.in);
        System.out.println("\n ID do modelo do carro para adicionar fabricante: ");
        int id = Integer.parseInt(s.nextLine());

        modeloCarro = modeloCarroController.buscarModeloCarro(id);

        if (modeloCarro != null) {
            modeloCarro.setFabricante(MenuFabricante.carregaInfoFabricanteParaModeloCarro());
        }

        System.out.println("\n Acessorios adicionados ao carro");
        if (modeloCarro.getFabricante() != null) {
            System.out.println("Nome: " + modeloCarro.getFabricante().getNome());
        } else {
            System.out.println("Nenhum fabricante adicionado.");
        }

        modeloCarroController.atualizaModeloCarro(modeloCarro);
    }

    private static void addCategoria() throws Exception {
        ModeloCarroController modeloCarroController = new ModeloCarroController();
        ModeloCarro modeloCarro;

        Scanner s = new Scanner(System.in);
        System.out.println("\n ID do Modelo de Carro para adicionar a Categoria: ");
        int id = Integer.parseInt(s.nextLine());

        modeloCarro = modeloCarroController.buscarModeloCarro(id);

        List<ECategoria> listCategoria = ECategoria.getListCategoria();

        System.out.println("### Categorias ###");
        for(ECategoria eCategoria : listCategoria){
            System.out.println("ID " + eCategoria.getId());
            System.out.println("Descrição: " + eCategoria.getCategoria());
        }

        System.out.println("\n ID da Categoria para adicionar oa Modelo de Carro: ");
        int id_categoria = Integer.parseInt(s.nextLine());

        ECategoria eCategoria = listCategoria.get(id_categoria);

        if (modeloCarro != null) {
            modeloCarro.setCategoria(eCategoria.getCategoria());
        }

        System.out.println("\n Categoria adicionada ao Modelo de Carro");
        if (modeloCarro.getCategoria() != null) {
            System.out.println("Descrição: " + modeloCarro.getCategoria());
        } else {
            System.out.println("Nenhuma Categoria adicionada.");
        }

        modeloCarroController.atualizaModeloCarro(modeloCarro);
    }

    private static void mostraInfoModeloCarro(ModeloCarro modeloCarro) {
        System.out.println("ID: " + modeloCarro.getId());
        System.out.println("Descricao: " + modeloCarro.getDescricao());

        if (modeloCarro.getFabricante() != null) {
            System.out.println("Fabricante: " + modeloCarro.getFabricante().getNome());
        } else {
            System.out.println("Fabricante: Nenhum Cadastrado");
        }

        if (modeloCarro.getCategoria() != null) {
            System.out.println("Categoria: " + modeloCarro.getCategoria());
        } else {
            System.out.println("Categoria: Nenhuma Cadastrada");
        }

        System.out.println("\n ");
    }
}
