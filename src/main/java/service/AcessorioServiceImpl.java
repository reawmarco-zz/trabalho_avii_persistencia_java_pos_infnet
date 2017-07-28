package service;

import dao.DAOFactory;
import model.Acessorios;
import java.util.List;

public class AcessorioServiceImpl implements DefaultService<Acessorios> {

    private DAOFactory dao = new DAOFactory();

    @Override
    public void adiciona(Acessorios entity) throws Exception {
        dao.getAcessoriosDAO().adiciona(entity);
    }

    @Override
    public void remove(Acessorios entity) throws Exception {
        dao.getAcessoriosDAO().remove(entity);
    }

    @Override
    public Acessorios atualiza(Acessorios entity) throws Exception {
        return this.dao.getAcessoriosDAO().atualiza(entity);
    }

    @Override
    public List<Acessorios> listaTudo() throws Exception {
        return this.dao.getAcessoriosDAO().listaTudo();
    }

    @Override
    public Acessorios procura(int id) throws Exception {
        return this.dao.getAcessoriosDAO().procura(id);
    }
}
