package dao;

import java.util.List;

public interface DAO<T> {

    public void adiciona(T entity);

    public void remove(T entity);

    public T atualiza(T entity);

    public List<T> listaTudo();

    public T procura(int id);

    public void comita();
}