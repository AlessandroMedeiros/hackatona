package engenharia.software.hackatona.pucrs.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

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

    @ManyToOne
    private AvaliadorModel avaliadorModel;

    @ManyToOne
    private TimeModel timeModel;

    public AvaliacaoModel() {
    }

    public AvaliacaoModel(Integer id, Integer softwareFuncionando, Integer processo, Integer pictch, Integer inovacao, Integer formacaoTime, AvaliadorModel avaliadorModel, TimeModel timeModel) {
        this.id = id;
        this.softwareFuncionando = softwareFuncionando;
        this.processo = processo;
        this.pictch = pictch;
        this.inovacao = inovacao;
        this.formacaoTime = formacaoTime;
        this.avaliadorModel = avaliadorModel;
        this.timeModel = timeModel;
    }
}
