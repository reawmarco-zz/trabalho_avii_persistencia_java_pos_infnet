package service;

import dao.DAOFactory;
import model.ModeloCarro;
import java.util.List;

public class ModeloCarroServiceImpl implements DefaultService<ModeloCarro> {

    private DAOFactory dao = new DAOFactory();

    @Override
    public void adiciona(ModeloCarro entity) throws Exception {
        dao.getModeloCarroDAO().adiciona(entity);
    }

    @Override
    public void remove(ModeloCarro entity) throws Exception {
        dao.getModeloCarroDAO().remove(entity);
    }

    @Override
    public ModeloCarro atualiza(ModeloCarro entity) throws Exception {
        return this.dao.getModeloCarroDAO().atualiza(entity);
    }

    @Override
    public List<ModeloCarro> listaTudo() throws Exception {
        return this.dao.getModeloCarroDAO().listaTudo();
    }

    @Override
    public ModeloCarro procura(int id) throws Exception {
        return this.dao.getModeloCarroDAO().procura(id);
    }
}
