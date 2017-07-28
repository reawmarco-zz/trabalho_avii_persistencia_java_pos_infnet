package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tb_aluguel", schema = "trabalho_avi")
public class Aluguel implements Serializable {

    private static final long serialVersionUID = -6124202963490695286L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private int id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_aluguel")
    private Calendar dataAluguel;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_devolucao")
    private Date dataDevolucao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_entrega")
    private Date dataEntrega;

    @Column(name="valor_total")
    private BigDecimal valorTotal;

    @Column(name="cnh_motorista")
    private String cnhMotorista;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apolice_seguro")
    private ApoliceSeguro apoliceSeguro;

    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;

    public Aluguel(int id, Calendar dataAluguel, Date dataDevolucao, Date dataEntrega, BigDecimal valorTotal, String cnhMotorista, ApoliceSeguro apoliceSeguro, Carro carro) {
        this.id = id;
        this.dataAluguel = dataAluguel;
        this.dataDevolucao = dataDevolucao;
        this.dataEntrega = dataEntrega;
        this.valorTotal = valorTotal;
        this.cnhMotorista = cnhMotorista;
        this.apoliceSeguro = apoliceSeguro;
        this.carro = carro;
    }

    public Aluguel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Calendar dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        new SimpleDateFormat("dd/MM/yyyy").format(dataEntrega);
        this.dataEntrega = dataEntrega;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }


    public String getCnhMotorista() {
        return cnhMotorista;
    }

    public void setCnhMotorista(String cnhMotorista) {
        this.cnhMotorista = cnhMotorista;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        new SimpleDateFormat("dd/MM/yyyy").format(dataDevolucao);
        this.dataDevolucao = dataDevolucao;
    }

    public BigDecimal calculaValorTotal(BigDecimal valorTotalAluguel, BigDecimal valorTotalFranquia, BigDecimal valorDiariaCarro){
        valorTotalAluguel = valorTotalAluguel.add(valorTotalFranquia);
        valorTotalAluguel.add(valorDiariaCarro);
        return valorTotalAluguel;
    }

    public ApoliceSeguro getApoliceSeguro() {
        return apoliceSeguro;
    }

    public void setApoliceSeguro(ApoliceSeguro apoliceSeguro) {
        this.apoliceSeguro = apoliceSeguro;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
