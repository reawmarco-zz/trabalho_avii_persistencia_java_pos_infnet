package menu;

import model.ApoliceSeguro;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class MenuApoliceSeguro {


    public static ApoliceSeguro carregaInfoApoliceSeguro() throws ParseException, SQLException {
        ApoliceSeguro apoliceSeguro = new ApoliceSeguro();
        Scanner s = new Scanner(System.in);

        System.out.println("\n #### Apolice Seguro ### \n");

        System.out.println("Proteção de Terceiros s-Sim / n-Não ");

        if (s.nextLine().equals("s")) {
            apoliceSeguro.setProtecaoTerceiro(true);
        } else {
            apoliceSeguro.setProtecaoTerceiro(false);
        }

        System.out.println("Proteção sobre Causas Naturais s-Sim / n-Não ");

        if (s.nextLine().equals("s")) {
            apoliceSeguro.setProtecaoCausasNaturais(true);
        } else {
            apoliceSeguro.setProtecaoCausasNaturais(false);
        }

        System.out.println("Proteção sobre Roubo s-Sim / n-Não ");

        if (s.nextLine().equals("s")) {
            apoliceSeguro.setProtecaoRoubo(true);
        } else {
            apoliceSeguro.setProtecaoRoubo(false);
        }

        System.out.println("Valor Franquia: ");
        apoliceSeguro.setValorFranquia(BigDecimal.valueOf(Double.valueOf(s.nextLine())));

        return apoliceSeguro;
    }
}