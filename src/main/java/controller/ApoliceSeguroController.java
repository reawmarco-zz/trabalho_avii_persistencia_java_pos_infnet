package controller;

import model.ApoliceSeguro;
import service.ApoliceSeguroServiceImpl;
import java.util.List;

public class ApoliceSeguroController {

    ApoliceSeguroServiceImpl apoliceSeguroService =  new ApoliceSeguroServiceImpl();

    public void addApoliceSeguro(ApoliceSeguro apoliceSeguro) throws Exception {
        apoliceSeguroService.adiciona(apoliceSeguro);
    }

    public void atualizaApoliceSeguro(ApoliceSeguro apoliceSeguro) throws Exception {
        apoliceSeguroService.atualiza(apoliceSeguro);
    }

    public void deletaApoliceSeguro(ApoliceSeguro apoliceSeguro) throws Exception {
        apoliceSeguroService.remove(apoliceSeguro);
    }

    public List<ApoliceSeguro> listApoliceSeguro() throws Exception {
        return apoliceSeguroService.listaTudo();
    }

    public ApoliceSeguro buscarApoliceSeguro(int id) throws Exception {
        return apoliceSeguroService.procura(id);
    }
}
