package menu;

import controller.CarroController;
import model.Acessorios;
import model.Carro;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MenuCarro {


    public static void menu() {
        System.out.println("#### MENU Carro #### \n");
        System.out.println("1 - Cadastro Carro");
        System.out.println("2 - Atualização Cadastro Carro");
        System.out.println("3 - Deletar Cadastro Carro");
        System.out.println("4 - Listar Todos os Carros");
        System.out.println("5 - Buscar Carro por nome");
        System.out.println("6 - Adicionar acessorio ao carro");
        System.out.println("7 - Adicionar modelo ao carro");
        System.out.println("8 - Voltar ao menu inicial");

        Scanner s = new Scanner(System.in);
        CarroController carroController = new CarroController();
        int opcao = s.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("#### MENU Cadastro Carro #### \n \n");
                try {
                    carroController.addCarro(carregaInfoCarro(false));
                    System.out.println("Cadastro realizada com sucesso! \n");
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro no cadastro do carro, retornando para o menu inicial \n");
                    menu();
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Erro no cadastro do carro, retornando para o menu inicial \n");
                    menu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                try {
                    listarCarros(carroController.listCarro());
                    carroController.atualizaCarro(carregaInfoCarro(true));
                    System.out.println("Atualização realizada com sucesso! \n");
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro ao atualizar cadastro do carro, retornando para o menu inicial \n");
                    menu();
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Erro ao atualizar cadastro do carro, retornando para o menu inicial \n");
                    menu();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case 3:
                deletarCarro();
                menu();
                break;

            case 4:
                try {
                    listarCarros(carroController.listCarro());
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro na pesquisa.Nenhum carro localizado! \n");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Erro na pesquisa.Nenhum carro localizado! \n");
                }
                menu();
                break;

            case 5:
                try {
                    listarCarro();
                    menu();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro na pesquisa. Nenhum carro localizado com este nome! \n");
                    menu();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Erro na pesquisa. Nenhum carro localizado com este nome! \n");
                    menu();
                }
                break;
            case 6:
                try {
                    addAcessoriosCarro();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Erro ao adicionar acessorio ao carro! \n");
                }
                menu();
                break;
            case 7:
                try {
                    addModeloCarro();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Erro ao adicionar modelo ao carro! \n");
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

    private static Carro carregaInfoCarro(boolean alterar) throws Exception {
        Carro carro = new Carro();
        CarroController carroController = new CarroController();
        Scanner s = new Scanner(System.in);

        if (alterar) {
            listarCarros(carroController.listCarro());
            System.out.println("\n ");
            System.out.println("\n Digite o ID do Carro que deseja alterar:  ");
            int id = (Integer.valueOf(s.nextLine()));

            carro = carroController.buscarCarro(id);

            if (carro.getId() == 0) {
                System.out.println("Não foi localizado nenhum carro com este ID.");
                MenuAluguel.menu();
            }

            carro.setId(id);
        }

        System.out.println("Digite a placa: ");
        carro.setPlaca(s.nextLine());

        System.out.println("Digite o chassi ");
        carro.setChassi(s.nextLine());

        System.out.println("Digite a cor: ");
        carro.setCor(s.nextLine());

        System.out.println("Digite o valor da diária ");
        carro.setValorDiaria(BigDecimal.valueOf(Double.parseDouble((s.nextLine()))));

        return carro;
    }

    private static void listarCarros(List<Carro> list) {
        System.out.println("#### MENU Resultado Pesquisa Carros #### \n");

        if (list.size() > 0) {
            for (Carro carro : list) {
                mostrarInfoCarro(carro);
            }
        } else {
            System.out.println("Nenhum cadastro de Motorista localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void listarCarro() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("#### MENU Busca Carro #### \n");

        System.out.println("Digite o ID: ");
        int id = Integer.parseInt(s.nextLine());

        CarroController carroController = new CarroController();
        Carro carro = carroController.buscarCarro(id);

        if (carro != null) {
            mostrarInfoCarro(carro);
        } else {
            System.out.println("Nenhum cadastro de carro com este ID foi localizado! \n ");
            System.out.println("######################################################## \n ");
        }
    }

    private static void deletarCarro() {
        CarroController carroController = new CarroController();
        System.out.println("#### MENU Deletar Carro #### \n ");

        try {
            listarCarros(carroController.listCarro());
            System.out.println("Digite o ID do carro que deseja deletar: ");
            Scanner s = new Scanner(System.in);

            int id = Integer.parseInt(s.nextLine());
            carroController.deletaCarro(carroController.buscarCarro(id));

            System.out.println("Carro deletado com sucesso!");
            menu();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar o carro! \n");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao deletar o carro! \n");
        }
    }

    public static Carro carregaInfoCarroParaAluguel() throws Exception {
        CarroController carroController = new CarroController();

        listarCarros(carroController.listCarro());

        Scanner s = new Scanner(System.in);
        System.out.println("\n #### MENU Busca Carro #### \n");
        System.out.println("Digite o ID: ");
        int id = Integer.parseInt(s.nextLine());

        Carro carro = carroController.buscarCarro(id);

        if (carro.getId() != null) {
            mostrarInfoCarro(carro);
        } else {
            System.out.println("Nenhum cadastro de motorista com este nome localizado! \n ");
            carregaListInfoCarro();
        }

        return carro;
    }

    private static void carregaListInfoCarro() throws Exception {

        System.out.println("#### MENU Resultado Pesquisa Carros #### \n");
        CarroController carroController = new CarroController();
        List<Carro> list = carroController.listCarro();

        if (list.size() > 0) {
            for (Carro carro : list) {
                mostrarInfoCarro(carro);
            }
        } else {
            System.out.println("Nenhum cadastro de Carro localizado! \n ");
            System.out.println("Cadastre um Carro para continuar o aluguel... Você será direcionado para o cadastro de Carros.");
            menu();
        }
    }

    private static void addAcessoriosCarro() throws Exception {
        CarroController carroController = new CarroController();
        Carro carro;

        listarCarros(carroController.listCarro());

        Scanner s = new Scanner(System.in);
        System.out.println("\n ID do carro para adicionar acessorio: ");
        int id = Integer.parseInt(s.nextLine());

        carro = carroController.buscarCarro(id);

        if (carro != null) {
            carro.setAcessorios(addAcessorioCarro(carro.getListAcessorios()));
        }

        System.out.println("\n Acessorios adicionados ao carro");
        if (carro.getListAcessorios().size() != 0) {
            for (Acessorios acessorios : carro.getListAcessorios()) {
                System.out.println("Descrição: " + acessorios.getDescricao());
            }
        } else {
            System.out.println("Nenhum acessorio adicionado.");
        }

        carroController.atualizaCarro(carro);
    }

    private static List<Acessorios> addAcessorioCarro(List<Acessorios> listaAcessorios) throws Exception {
        if (listaAcessorios.size() == 0) {
            listaAcessorios.add(0, MenuAcessorios.carregaInfoAcessorioParaCarro());
        } else {
            listaAcessorios.add(listaAcessorios.size() - 1, MenuAcessorios.carregaInfoAcessorioParaCarro());
        }
        return listaAcessorios;
    }

    private static void addModeloCarro() throws Exception {
        CarroController carroController = new CarroController();
        Carro carro;

        listarCarros(carroController.listCarro());

        Scanner s = new Scanner(System.in);
        System.out.println("\n ID do carro para adicionar modelo: ");
        int id = Integer.parseInt(s.nextLine());

        carro = carroController.buscarCarro(id);

        if (carro != null) {
            carro.setModeloCarro(MenuModeloCarro.carregaInfoModeloCarroParaCarro());
        }

        System.out.println("\n Modelo adicionado ao carro");
        if (carro.getModeloCarro() != null) {
            System.out.println("Nome: " + carro.getModeloCarro().getDescricao());
        } else {
            System.out.println("Nenhum modelo adicionado.");
        }

        carroController.atualizaCarro(carro);
    }


    private static void mostrarInfoCarro(Carro carro) {
        System.out.println("ID: " + carro.getId());
        System.out.println("Placa: " + carro.getPlaca());
        System.out.println("Chassi: " + carro.getChassi());
        System.out.println("Cor: " + carro.getCor());
        System.out.println("Valor Diária: " + carro.getValorDiaria());

        System.out.println("Acessorios adicionados ao carro");
        if (carro.getListAcessorios().size() != 0) {
            for (Acessorios acessorios : carro.getListAcessorios()) {
                System.out.println("Descrição: " + acessorios.getDescricao());
            }
        } else {
            System.out.println("Nenhum acessorio adicionado.");
        }
    }
}


