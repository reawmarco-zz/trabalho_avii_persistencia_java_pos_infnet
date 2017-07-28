package controller;

import dao.IMotoristaDAO;
import dao.MotoristaDAO;
import model.Motorista;

import java.sql.SQLException;
import java.util.List;

public class MotoristaController {

    IMotoristaDAO motoristaDAO = new MotoristaDAO();


    public void addMotorista(Motorista motorista) throws SQLException {
        motoristaDAO.inserir(motorista);
    }

    public void atualizaMotorista(Motorista motorista) throws SQLException {
        motoristaDAO.atualizar(motorista);
    }

    public void deleteMotorista(String CNH) throws SQLException {
        motoristaDAO.deletar(CNH);
    }

    public List<Motorista> listMotorista() throws SQLException {
        return motoristaDAO.buscarTodos();
    }

    public Motorista buscarMotorista(String nome) throws SQLException {
        return motoristaDAO.buscar(nome);
    }

    public Motorista buscarMotorista(int id) throws SQLException {
        return motoristaDAO.buscar(id);
    }

}

