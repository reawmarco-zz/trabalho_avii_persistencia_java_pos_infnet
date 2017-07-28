package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="tb_acessorio")
public class Acessorios implements Serializable{

    private static final long serialVersionUID = -1030196192032129616L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private  Integer id;

    @Column(name="descricao")
    private String descricao;

    @ManyToMany(mappedBy = "listAcessorios")
    private List<Carro> carros;

    public Acessorios(){

    }

    public Acessorios(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
