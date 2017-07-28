package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "tb_carro")
public class Carro implements Serializable {

    private static final long serialVersionUID = -9048131815132861347L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private int id;

    @Column(name="placa")
    private String placa;

    @Column(name="chassi")
    private String chassi;

    @Column(name="cor")
    private String cor;

    @Column(name="valor_diaria")
    private BigDecimal valorDiaria;

    @ManyToMany
    @JoinTable(name="carro_acessorios", joinColumns=
            {@JoinColumn(name="id_carro")}, inverseJoinColumns=
            {@JoinColumn(name="id_acessorio")})
    private List<Acessorios> listAcessorios;

    @ManyToOne
    @JoinColumn(name = "modelo_carro_id")
    private ModeloCarro modeloCarro;


    public Carro(){

    }

    public Carro(int id, String placa, String chassi, String cor, BigDecimal valorDiaria, List<Acessorios> listAcessorios, ModeloCarro modeloCarro) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.valorDiaria = valorDiaria;
        this.listAcessorios = listAcessorios;
        this.modeloCarro = modeloCarro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public List<Acessorios> getListAcessorios() {
        return listAcessorios;
    }

    public void setAcessorios(List<Acessorios> listAcessorios) {
        this.listAcessorios = listAcessorios;
    }

    public void setListAcessorios(List<Acessorios> listAcessorios) {
        this.listAcessorios = listAcessorios;
    }

    public ModeloCarro getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(ModeloCarro modeloCarro) {
        this.modeloCarro = modeloCarro;
    }
}
