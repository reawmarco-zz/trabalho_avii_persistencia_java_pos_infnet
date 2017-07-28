package model;

import java.io.Serializable;
import java.util.Date;

public class Funcionario extends Pessoa implements Serializable {

    private static final long serialVersionUID = -5129665337646855058L;

    private Integer id;
    private String numMatricula;

    public Funcionario(String nome, Date dataNascimento, String cpf, String numMatricula, Integer id) {
        super(nome, dataNascimento, cpf);
        this.numMatricula = numMatricula;
        this.id = id;
    }

    public Funcionario(String numMatricula, Integer id) {
        this.numMatricula = numMatricula;
        this.id =  id;
    }

    public Funcionario(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }
}
