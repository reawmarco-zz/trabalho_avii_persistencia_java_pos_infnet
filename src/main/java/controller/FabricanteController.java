package controller;

import model.Fabricante;
import service.FabricanteServiceImpl;

import java.util.List;

public class FabricanteController {

    FabricanteServiceImpl fabricanteService = new FabricanteServiceImpl();

    public void addFabricante(Fabricante fabricante) throws Exception {
        fabricanteService.adiciona(fabricante);
    }

    public void atualizaFabricante(Fabricante fabricante) throws Exception {
        fabricanteService.atualiza(fabricante);
    }

    public void deletaFabricante(Fabricante fabricante) throws Exception {
        fabricanteService.remove(fabricante);
    }

    public List<Fabricante> listFabricante() throws Exception {
        return fabricanteService.listaTudo();
    }

    public Fabricante buscarFabricante(int id) throws Exception {
        return fabricanteService.procura(id);
    }
}

