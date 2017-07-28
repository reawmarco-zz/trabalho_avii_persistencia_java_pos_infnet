package menu;

import controller.AluguelController;
import model.Acessorios;
import model.Aluguel;
import util.Util;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import static menu.MenuCarro.carregaInfoCarroParaAluguel;
import static menu.MenuMotorista.carregaInfoMotoristaParaAluguel;

public class MenuAluguel {

    public static void menu() {
        System.out.println("#### MENU Aluguel #### \n ");
        System.out.println("1 - Cadastro Aluguel");
        System.out.println("2 - Atualização Cadastro Aluguel");
        System.out.println("3 - Deletar Cadastro Aluguel");
        System.out.println("4 - Listar Todos os Alugueis");
        System.out.println("5 - Buscar Aluguel por id");

        Scanner s = new Scanner(System.in);
        AluguelController aluguelController = new AluguelController();
        int opcao = s.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("#### MENU Cadastro Aluguel #### \n \n");
                try {
                    aluguelController.addAluguel(carregaInfoAluguel(false));
                    System.out.println("Cadastro realizada com sucesso! \n");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro no cadastro do aluguel, retornando para o menu inicial \n");
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Erro no cadastro do aluguel, retornando para o menu inicial \n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu();
                break;

            case 2:
                try {
                    listarAlugueis(aluguelController.listAluguel());
                    aluguelController.atualizaAluguel(carregaInfoAluguel(true));
                    System.out.println("Atualização realizada com sucesso! \n");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro ao atualizar cadastro do funcionario, retornando para o menu inicial \n");
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("Erro ao atualizar cadastro do funcionario, retornando para o menu inicial \n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu();
                break;

            case 3:
                deletarAluguel();
                Start.menuInicial();
                break;

            case 4:
                try {
                    listarAlugueis(aluguelController.listAluguel());
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro na pesquisa. Nenhum aluguel localizado! \n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                menu();
                break;

            case 5:
                try {
                    listaAluguel();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Erro na pesquisa. Nenhum Aluguel localizado com este nome! \n");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Erro na pesquisa. Nenhum Aluguel localizado com este nome! \n");
                }
                menu();
                break;

            default:
                System.out.println("Opção errada, voltando para o menu inicial \n");
                Start.menuInicial();
        }
    }

    private static Aluguel carregaInfoAluguel(boolean alterar) throws Exception {
        Aluguel aluguel = new Aluguel();
        AluguelController aluguelController = new AluguelController();
        String CNH;

        Scanner s = new Scanner(System.in);

        if (alterar) {
            listarAlugueis(aluguelController.listAluguel());
            System.out.println("\n ");
            System.out.println("\n Digite o ID do Aluguel que deseja alterar:  ");
            int id = (Integer.valueOf(s.nextLine()));

            aluguel = aluguelController.buscarAluguel(id);

            if (aluguel.getId() == 0) {
                System.out.println("Não foi localizado nenhum aluguel com este ID.");
                MenuAluguel.menu();
            }

            aluguel.setId(id);
        }

        Calendar calendar = Calendar.getInstance();
        aluguel.setDataAluguel(Util.convertToCalendar(calendar.getTime()));

        System.out.println("Data de Aluguel: " + aluguel.getDataAluguel().getTime());
        System.out.println("Digite a data de devolução: dd/MM/yyyy ");
        aluguel.setDataDevolucao(Util.convertToDate(s.nextLine()));

        System.out.println("Digite a data de entrega: dd/MM/yyyy ");
        aluguel.setDataEntrega(Util.convertToDate(s.nextLine()));

        do {
            // carrega as informações do motorista para setar nos dados do aluguel.
            CNH = carregaInfoMotoristaParaAluguel();
        }
        while (CNH == null);

        System.out.println("Número da CNH do Motorista: " + CNH);
        aluguel.setCnhMotorista(CNH);

        aluguel.setCarro(carregaInfoCarroParaAluguel());

        //carrega informações apolice seguro
        aluguel.setApoliceSeguro(MenuApoliceSeguro.carregaInfoApoliceSeguro());

        System.out.println("Digite o Valor Total do Aluguel: ");
        aluguel.setValorTotal(aluguel.calculaValorTotal(BigDecimal.valueOf(Double.parseDouble((s.nextLine()))),
                aluguel.getApoliceSeguro().getValorFranquia(),
                aluguel.getCarro().getValorDiaria()));

        return aluguel;
    }

    private static void listarAlugueis(List<Aluguel> list) {

        System.out.println("#### MENU Resultado Pesquisa Aluguel #### \n");

        if (list.size() >= 1 || list != null) {
            for (Aluguel aluguel : list) {
                mostrarInfoAluguel(aluguel);
            }
        } else {
            System.out.println("Nenhum cadastro de aluguel localizado! \n ");
            System.out.println("######################################################## \n ");
            menu();
        }
    }

    private static void listaAluguel() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("#### MENU Busca Aluguel #### \n");

        System.out.println("Digite o ID: ");
        String id = s.nextLine();

        AluguelController aluguelController = new AluguelController();
        Aluguel aluguel = aluguelController.buscarAluguel(Integer.parseInt(id));

        if (aluguel.getCnhMotorista() != null) {
            mostrarInfoAluguel(aluguel);
        } else {
            System.out.println(" \n Nenhum cadastro de aluguel com este ID localizado! \n ");
            System.out.println(" \n ######################################################## \n ");
        }
    }

    private static void deletarAluguel() {

        AluguelController aluguelController = new AluguelController();

        System.out.println("#### MENU Deletar Aluguel #### \n ");

        try {
            listarAlugueis(aluguelController.listAluguel());
            System.out.println("Digite o número de ID do Aluguel que deseja deletar: ");
            Scanner s = new Scanner(System.in);
            String id = s.nextLine();

            Aluguel aluguel = aluguelController.buscarAluguel(Integer.parseInt(id));

            aluguelController.deleteAluguel(aluguel);
            System.out.println("Aluguel deletado com sucesso! \n");
            Start.menuInicial();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao deletar o Aluguel! \n");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Erro ao deletar o Aluguel! \n");
        }
    }

    private static void mostrarInfoAluguel(Aluguel aluguel) {
        System.out.println("\n ### DADOS ALUGUEL ### \n");
        System.out.println("ID: " + aluguel.getId());
        System.out.println("Data Aluguel: " + aluguel.getDataAluguel().getTime());
        System.out.println("Data Entrega: " + aluguel.getDataEntrega());
        System.out.println("Data Devolução: " + aluguel.getDataDevolucao());

        System.out.println("\n ### MOTORISTA ### \n");
        System.out.println("CNH Motorista: " + aluguel.getCnhMotorista());

        System.out.println("\n ### SEGURO ### \n");
        System.out.println("Proteção Terceiros: " + (aluguel.getApoliceSeguro().getProtecaoTerceiro() ? "SIM" : "NÃO"));
        System.out.println("Proteção Causas Naturais: " + (aluguel.getApoliceSeguro().getProtecaoCausasNaturais() ? "SIM" : "NÃO"));
        System.out.println("Proteção Roubo: " + (aluguel.getApoliceSeguro().getProtecaoRoubo() ? "SIM" : "NÃO"));
        System.out.println("Valor Franquia Seguro: " + aluguel.getApoliceSeguro().getValorFranquia());

        System.out.println("\n ### CARRO ### \n");

        if (aluguel.getCarro() != null) {
            System.out.println("ID: " + aluguel.getCarro().getId());
            System.out.println("Placa: " + aluguel.getCarro().getPlaca());
            System.out.println("Cor: " + aluguel.getCarro().getCor());
            System.out.println("Valor Diária: " + aluguel.getCarro().getValorDiaria());

            if (aluguel.getCarro().getListAcessorios() != null || aluguel.getCarro().getListAcessorios().size() >= 1) {
                for (Acessorios acessorios : aluguel.getCarro().getListAcessorios()) {
                    System.out.println("Acessorio: " + acessorios.getDescricao());
                }
            } else {
                System.out.println("** Carro sem acessorios cadastrados!");
            }

            if (aluguel.getCarro().getModeloCarro() != null) {
                System.out.println("Modelo: " + aluguel.getCarro().getModeloCarro().getDescricao());

                if (aluguel.getCarro().getModeloCarro().getCategoria() != null) {
                    System.out.println("Categoria: " + aluguel.getCarro().getModeloCarro().getCategoria());
                }else {
                    System.out.println("** Modelo sem categoria cadastrada!");
                }

                if (aluguel.getCarro().getModeloCarro().getFabricante() != null) {
                    System.out.println("Fabricante: " + aluguel.getCarro().getModeloCarro().getFabricante().getNome());
                }else {
                    System.out.println("** Modelo sem fabricante cadastrado!");
                }

            } else {
                System.out.println("** Carro sem modelo cadastrado!");
            }


        }else {
            System.out.println("** Aluguel sem carro cadastrado!");
        }

        System.out.println("\n ### TOTAL ALUGUEL  ### \n");
        System.out.println("Valor Total Aluguel: " + aluguel.getValorTotal());

        System.out.println("\n #########################################################\n ");
    }
}