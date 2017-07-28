package menu;

import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        menuInicial();
    }

    public static void menuInicial() {

        System.out.println("\n \n #### Marco Antônio de Oliveira - Trab A2 #### \n \n \n");
        System.out.println("#### MENU Inicial ####");
        System.out.println("1 - Funcionário");
        System.out.println("2 - Motorista");
        System.out.println("3 - Aluguel");
        System.out.println("4 - Carro");
        System.out.println("5 - Cadastros Basicos");

        Scanner s = new Scanner(System.in);
        int opcao = s.nextInt();

        switch (opcao) {
            case 1:
                MenuFuncionario.menu();
                break;
            case 2:
                MenuMotorista.menu();
                break;
            case 3:
                MenuAluguel.menu();
                break;
            case 4:
                MenuCarro.menu();
                break;
            case 5:
                MenuCadastrosBasicos.menu();
                break;
            default:
                menuInicial();
        }
    }
}
