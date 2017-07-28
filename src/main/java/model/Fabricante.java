package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_fabricante")
public class Fabricante implements Serializable {

    private static final long serialVersionUID = 2148319895390213646L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private int id;

    @Column(name = "nome")
    private String nome;

    public Fabricante(){

    }

    public Fabricante(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
