package service;

import dao.DAOFactory;
import model.Aluguel;
import javax.transaction.Transactional;
import java.util.List;

public class AluguelServiceImpl  implements DefaultService<Aluguel> {

    private DAOFactory dao = new DAOFactory();

    @Override
    @Transactional
    public void adiciona(Aluguel entity) throws Exception {
        dao.getAluguelDAO().adiciona(entity);
    }

    @Override
    @Transactional
    public void remove(Aluguel entity) throws Exception {
        dao.getAluguelDAO().remove(entity);
    }

    @Override
    @Transactional
    public Aluguel atualiza(Aluguel entity) throws Exception {
        return this.dao.getAluguelDAO().atualiza(entity);
    }

    @Override
    public List<Aluguel> listaTudo() throws Exception {
        return this.dao.getAluguelDAO().listaTudo();
    }

    @Override
    public Aluguel procura(int id) throws Exception {
        return this.dao.getAluguelDAO().procura(id);
    }
}
