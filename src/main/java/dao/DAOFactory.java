package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import model.*;

public class DAOFactory {

    @PersistenceContext(unitName = "trabalhoAVII")
    private EntityManager entityManager;

    private EntityManagerFactory entityManagerFactory;

    public DAOFactory() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("trabalhoAVII");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public DAO<Aluguel> getAluguelDAO() {
        return new DefaultDAO<Aluguel>(entityManager, Aluguel.class);
    }

    public DAO<ApoliceSeguro> getApoliceSeguro(){
        return new DefaultDAO<ApoliceSeguro>(entityManager, ApoliceSeguro.class);
    }

    public DAO<Carro> getCarroDAO(){
        return new DefaultDAO<Carro>(entityManager,Carro.class);
    }

    public DAO<Acessorios> getAcessoriosDAO(){
        return new DefaultDAO<Acessorios>(entityManager,Acessorios.class);
    }

    public DAO<ModeloCarro> getModeloCarroDAO(){
        return new DefaultDAO<ModeloCarro>(entityManager,ModeloCarro.class);
    }

    public DAO<Fabricante> getFabricanteDAO(){
        return new DefaultDAO<Fabricante>(entityManager, Fabricante.class);
    }
}