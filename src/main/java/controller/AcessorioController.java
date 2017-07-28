package controller;

import model.Acessorios;
import service.AcessorioServiceImpl;
import java.util.List;

public class AcessorioController {

    AcessorioServiceImpl acessorioService = new AcessorioServiceImpl();

    public void addAcessorios(Acessorios acessorios) throws Exception {
        acessorioService.adiciona(acessorios);
    }

    public void atualizaAcessorios(Acessorios acessorios) throws Exception {
        acessorioService.atualiza(acessorios);
    }

    public void deletaAcessorios(Acessorios acessorios) throws Exception {
        acessorioService.remove(acessorios);
    }

    public List<Acessorios> listAcessorios() throws Exception {
        return acessorioService.listaTudo();
    }

    public Acessorios buscarAcessorios(int id) throws Exception {
        return acessorioService.procura(id);
    }
}

