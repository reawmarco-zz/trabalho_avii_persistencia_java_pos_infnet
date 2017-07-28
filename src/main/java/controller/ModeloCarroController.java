package controller;

import model.ModeloCarro;
import service.ModeloCarroServiceImpl;

import java.util.List;

public class ModeloCarroController {

    ModeloCarroServiceImpl modeloCarroService = new ModeloCarroServiceImpl();

    public void addModeloCarro(ModeloCarro modeloCarro) throws Exception {
        modeloCarroService.adiciona(modeloCarro);
    }

    public void atualizaModeloCarro(ModeloCarro modeloCarro) throws Exception {
        modeloCarroService.atualiza(modeloCarro);
    }

    public void deletaModeloCarro(ModeloCarro modeloCarro) throws Exception {
        modeloCarroService.remove(modeloCarro);
    }

    public List<ModeloCarro> listModeloCarro() throws Exception {
        return modeloCarroService.listaTudo();
    }

    public ModeloCarro buscarModeloCarro(int id) throws Exception {
        return modeloCarroService.procura(id);
    }
}
