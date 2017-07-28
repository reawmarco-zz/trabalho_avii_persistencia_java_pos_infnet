package model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_apolice", schema = "trabalho_avi")
public class ApoliceSeguro implements Serializable {

    private static final long serialVersionUID = -1835966102161597915L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_apolice_seguro", unique = true, nullable = false)
    private Integer idApoliceSeguro;

    @Column(name = "valor_franquia")
    private BigDecimal valorFranquia;

    @Column(name = "protecao_terceiros")
    private boolean protecaoTerceiro;

    @Column(name = "protecao_causas_naturais")
    private boolean protecaoCausasNaturais;

    @Column(name = "protecao_roubo")
    private boolean protecaoRoubo;

    public ApoliceSeguro() {

    }

    public ApoliceSeguro(Integer idApoliceSeguro, BigDecimal valorFranquia, boolean protecaoTerceiro, boolean protecaoCausasNaturais, boolean protecaoRoubo) {
        this.idApoliceSeguro = idApoliceSeguro;
        this.valorFranquia = valorFranquia;
        this.protecaoTerceiro = protecaoTerceiro;
        this.protecaoCausasNaturais = protecaoCausasNaturais;
        this.protecaoRoubo = protecaoRoubo;
    }

    public Integer getIdApoliceSeguro() {
        return idApoliceSeguro;
    }

    public void setIdApoliceSeguro(Integer idApoliceSeguro) {
        this.idApoliceSeguro = idApoliceSeguro;
    }

    public BigDecimal getValorFranquia() {
        return valorFranquia;
    }

    public void setValorFranquia(BigDecimal valorFranquia) {
        this.valorFranquia = valorFranquia;
    }

    public boolean getProtecaoTerceiro() {
        return protecaoTerceiro;
    }

    public void setProtecaoTerceiro(boolean protecaoTerceiro) {
        this.protecaoTerceiro = protecaoTerceiro;
    }

    public boolean getProtecaoCausasNaturais() {
        return protecaoCausasNaturais;
    }

    public boolean getProtecaoRoubo() {
        return protecaoRoubo;
    }

    public void setProtecaoRoubo(boolean protecaoRoubo) {
        this.protecaoRoubo = protecaoRoubo;
    }

    public void setProtecaoCausasNaturais(boolean protecaoCausasNaturais) {
        this.protecaoCausasNaturais = protecaoCausasNaturais;
    }

}
