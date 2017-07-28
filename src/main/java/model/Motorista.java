package model;

import java.io.Serializable;
import java.util.Date;

public class Motorista extends Pessoa implements Serializable {

    private static final long serialVersionUID = -502475791080393954L;

    private Integer id;
    private String numCNH;

    public Motorista(String nome, Date dataNascimento, String cpf, String numCNH, Integer id) {
        super(nome, dataNascimento, cpf);
        this.numCNH = numCNH;
        this.id = id;
    }

    public Motorista(String nome, Date dataNascimento, String cpf, String numCNH) {
        super(nome, dataNascimento, cpf);
        this.numCNH = numCNH;
    }

    public Motorista(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumCNH() {
        return numCNH;
    }

    public void setNumCNH(String numCNH) {
        this.numCNH = numCNH;
    }
}
