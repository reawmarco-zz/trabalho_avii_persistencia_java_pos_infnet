package service;

import dao.DAOFactory;
import model.ApoliceSeguro;
import java.util.List;
import javax.transaction.Transactional;

public class ApoliceSeguroServiceImpl implements DefaultService<ApoliceSeguro> {

    private DAOFactory dao = new DAOFactory();

    @Override
    @Transactional
    public void adiciona(ApoliceSeguro entity) throws Exception {
        dao.getApoliceSeguro().adiciona(entity);
    }

    @Override
    @Transactional
    public void remove(ApoliceSeguro entity) throws Exception {
        dao.getApoliceSeguro().remove(entity);
    }

    @Override
    @Transactional
    public ApoliceSeguro atualiza(ApoliceSeguro entity) throws Exception {
        return this.dao.getApoliceSeguro().atualiza(entity);
    }

    @Override
    public List<ApoliceSeguro> listaTudo() throws Exception {
        return this.dao.getApoliceSeguro().listaTudo();
    }

    @Override
    public ApoliceSeguro procura(int id) throws Exception {
        return this.dao.getApoliceSeguro().procura(id);
    }
}
