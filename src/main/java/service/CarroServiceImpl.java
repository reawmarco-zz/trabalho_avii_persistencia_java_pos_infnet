package service;

import dao.DAOFactory;
import model.Carro;
import java.util.List;

public class CarroServiceImpl implements DefaultService<Carro> {

    private DAOFactory dao = new DAOFactory();

    @Override
    public void adiciona(Carro entity) throws Exception {
        dao.getCarroDAO().adiciona(entity);

    }

    @Override
    public void remove(Carro entity) throws Exception {
        dao.getCarroDAO().remove(entity);
   }

    @Override
    public Carro atualiza(Carro entity) throws Exception {
        return this.dao.getCarroDAO().atualiza(entity);
    }

    @Override
    public List<Carro> listaTudo() throws Exception {
        return this.dao.getCarroDAO().listaTudo();
    }

    @Override
    public Carro procura(int id) throws Exception {
        return this.dao.getCarroDAO().procura(id);
    }
}
