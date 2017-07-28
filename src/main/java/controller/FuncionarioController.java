package controller;

import dao.FuncionarioDAO;
import dao.IFuncionarioDAO;
import model.Funcionario;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {

    IFuncionarioDAO funcionarioDAO = new FuncionarioDAO();


    public void addFuncionario(Funcionario funcionario) throws SQLException {
        funcionarioDAO.inserir(funcionario);
    }

    public void atualizaFuncionario(Funcionario funcionario) throws SQLException {
        funcionarioDAO.atualizar(funcionario);
    }

    public void deleteFuncionario(String numMatricula) throws SQLException {
        funcionarioDAO.deletar(numMatricula);
    }

    public List<Funcionario> listFuncionario() throws SQLException {
        return funcionarioDAO.buscarTodos();
    }

    public Funcionario buscarFuncionario(String nome) throws SQLException {
        return funcionarioDAO.buscar(nome);
    }

    public Funcionario buscarFuncionario(int id) throws SQLException {
        return funcionarioDAO.buscar(id);
    }

}
