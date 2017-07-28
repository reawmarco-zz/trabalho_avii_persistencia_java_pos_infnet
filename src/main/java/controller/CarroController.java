package controller;

import model.Carro;
import service.CarroServiceImpl;

import java.util.List;

public class CarroController {

    CarroServiceImpl carroService =  new CarroServiceImpl();

    public void addCarro(Carro carro) throws Exception {
        carroService.adiciona(carro);
    }

    public void atualizaCarro(Carro carro) throws Exception {
        carroService.atualiza(carro);
    }

    public void deletaCarro(Carro carro) throws Exception {
        carroService.remove(carro);
    }

    public List<Carro> listCarro() throws Exception {
        return carroService.listaTudo();
    }

    public Carro buscarCarro(int id) throws Exception {
        return carroService.procura(id);
    }
}