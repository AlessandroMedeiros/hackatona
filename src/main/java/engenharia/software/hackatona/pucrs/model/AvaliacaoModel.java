package engenharia.software.hackatona.pucrs.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "avaliacao")
public class AvaliacaoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Min(0)
    @Max(5)
    @Column(name = "softwareFuncionando")
    private Integer softwareFuncionando;

    @NotNull
    @Min(0)
    @Max(5)
    @Column(name = "processo")
    private Integer processo;

    @NotNull
    @Min(0)
    @Max(5)
    @Column(name = "pictch")
    private Integer pictch;

    @NotNull
    @Min(0)
    @Max(5)
    @Column(name = "inovacao")
    private Integer inovacao;

    @NotNull
    @Min(0)
    @Max(5)
    @Column(name = "formacaoTime")
    private Integer formacaoTime;

    public AvaliacaoModel() {
    }

    public AvaliacaoModel(Integer id, Integer softwareFuncionando, Integer processo, Integer pictch, Integer inovacao, Integer formacaoTime) {
        this.id = id;
        this.softwareFuncionando = softwareFuncionando;
        this.processo = processo;
        this.pictch = pictch;
        this.inovacao = inovacao;
        this.formacaoTime = formacaoTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoftwareFuncionando() {
        return softwareFuncionando;
    }

    public void setSoftwareFuncionando(Integer softwareFuncionando) {
        this.softwareFuncionando = softwareFuncionando;
    }

    public Integer getProcesso() {
        return processo;
    }

    public void setProcesso(Integer processo) {
        this.processo = processo;
    }

    public Integer getPictch() {
        return pictch;
    }

    public void setPictch(Integer pictch) {
        this.pictch = pictch;
    }

    public Integer getInovacao() {
        return inovacao;
    }

    public void setInovacao(Integer inovacao) {
        this.inovacao = inovacao;
    }

    public Integer getFormacaoTime() {
        return formacaoTime;
    }

    public void setFormacaoTime(Integer formacaoTime) {
        this.formacaoTime = formacaoTime;
    }
}
