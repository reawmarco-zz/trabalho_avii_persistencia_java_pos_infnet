package service;

import org.omg.CORBA.portable.ApplicationException;

import java.util.List;

public interface DefaultService<T> {

    public void adiciona(T entity) throws ApplicationException, Exception;

    public void remove(T entity) throws ApplicationException, Exception;

    public T atualiza(T entity) throws ApplicationException, Exception;

    public List<T> listaTudo() throws ApplicationException, Exception;

    public T procura(int id) throws ApplicationException, Exception;

}