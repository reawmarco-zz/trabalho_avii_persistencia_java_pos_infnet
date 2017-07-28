package dao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.persistence.EntityManager;

public class DefaultDAO<T> implements DAO<T>  {

    protected EntityManager entityManager;
    public Class<T> classe;

    public DefaultDAO(EntityManager entityManager, Class<T> classe) {
        this.entityManager = entityManager;
        this.classe = classe;
    }

    public void adiciona(T entity) {
        try{
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(entity);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex){
            this.entityManager.getTransaction().rollback();
            this.entityManager.getTransaction().commit();
            ex.printStackTrace();
        }
    }

    public void remove(T entity) {
        try {
            Class[] paramTypes = null;
            Method method = classe.getDeclaredMethod("getId", paramTypes);
            Object[] args = null;
            int id = (int) method.invoke(entity, args);
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(this.entityManager.find(classe, id));
            this.entityManager.getTransaction().commit();
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.getTransaction().commit();
            e.printStackTrace();
        }
    }

    public T atualiza(T entity) {
        try {
            this.entityManager.getTransaction().begin();
            entity = this.entityManager.merge(entity);
            this.entityManager.getTransaction().commit();
        } catch (Exception ex) {
            this.entityManager.getTransaction().rollback();
            this.entityManager.getTransaction().commit();
            ex.printStackTrace();
        }

        return entity;
    }

    public List<T> listaTudo() {
        return this.entityManager.createQuery("select t from " + this.classe.getSimpleName() + " t", classe).getResultList();
    }


    public T procura(int id) {
        return (T) entityManager.find(classe, id);
    }

    public void comita() {
        entityManager.flush();
    }

    public Class<T> getClasse() {
        return classe;
    }

    public void setClasse(Class<T> classe) {
        this.classe = classe;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
