package service;

import dao.DAOFactory;
import model.Fabricante;
import java.util.List;

public class FabricanteServiceImpl implements DefaultService<Fabricante> {

    private DAOFactory dao = new DAOFactory();

    @Override
    public void adiciona(Fabricante entity) throws Exception {
        dao.getFabricanteDAO().adiciona(entity);
    }

    @Override
    public void remove(Fabricante entity) throws Exception {
        dao.getFabricanteDAO().remove(entity);
    }

    @Override
    public Fabricante atualiza(Fabricante entity) throws Exception {
        return this.dao.getFabricanteDAO().atualiza(entity);
    }

    @Override
    public List<Fabricante> listaTudo() throws Exception {
        return this.dao.getFabricanteDAO().listaTudo();
    }

    @Override
    public Fabricante procura(int id) throws Exception {
        return this.dao.getFabricanteDAO().procura(id);
    }
}