package model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_modelo_carro")
public class ModeloCarro implements Serializable{

    private static final long serialVersionUID = -1312593635062201953L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    @Column(name = "categoria")
    private String categoria;

    public ModeloCarro(){

    }

    public ModeloCarro(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public ModeloCarro(int id, String descricao, Fabricante fabricante) {
        this.id =  id;
        this.descricao = descricao;
        this.fabricante = fabricante;
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

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
