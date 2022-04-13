package engenharia.software.hackatona.pucrs.controller.dto;

import engenharia.software.hackatona.pucrs.model.AvaliadorModel;
import engenharia.software.hackatona.pucrs.model.TimeModel;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NovaAvaliacaoDTO implements Serializable {

    private Integer id;
    private Integer softwareFuncionando;
    private Integer processo;
    private Integer pictch;
    private Integer inovacao;
    private Integer formacaoTime;
    private AvaliadorModel avaliadorModel;
    private TimeModel timeModel;

    public NovaAvaliacaoDTO() {
    }

    public NovaAvaliacaoDTO(Integer id, Integer softwareFuncionando, Integer processo, Integer pictch, Integer inovacao, Integer formacaoTime, AvaliadorModel avaliadorModel, TimeModel timeModel) {
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
