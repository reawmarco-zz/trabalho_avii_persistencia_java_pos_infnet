package controller;


import model.Aluguel;
import service.AluguelServiceImpl;
import service.ApoliceSeguroServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class AluguelController {

    AluguelServiceImpl aluguelService = new AluguelServiceImpl();

    public void addAluguel(Aluguel aluguel) throws Exception {
        aluguelService.adiciona(aluguel);
    }

    public Aluguel atualizaAluguel(Aluguel aluguel) throws Exception {
        return aluguelService.atualiza(aluguel);
    }

    public void deleteAluguel(Aluguel aluguel) throws Exception {
        aluguelService.remove(aluguel);
    }

    public List<Aluguel> listAluguel() throws Exception {
        List<Aluguel> listAluguel = new ArrayList<>();
        listAluguel = aluguelService.listaTudo();
        return listAluguel;
    }

    public Aluguel buscarAluguel(int id) throws Exception {
        return aluguelService.procura(id);
    }
}
