package menu;

import java.util.Scanner;

public class MenuCadastrosBasicos {

    public static void menu() {

        System.out.println("#### MENU Cadastros Basicos ####");
        System.out.println("1 - Cadastrar Acessorios Carro");
        System.out.println("2 - Cadastrar Modelo Carro");
        System.out.println("3 - Cadastrar Fabricante Carro");
        System.out.println("4 - Menu Inicial");

        Scanner s = new Scanner(System.in);
        int opcao = s.nextInt();

        switch (opcao) {
            case 1:
                MenuAcessorios.menu();
                break;
            case 2:
                MenuModeloCarro.menu();
                break;
            case 3:
                MenuFabricante.menu();
                break;
            default:
                Start.menuInicial();
        }
    }
}
