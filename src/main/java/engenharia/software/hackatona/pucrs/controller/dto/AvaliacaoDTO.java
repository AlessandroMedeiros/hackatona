package engenharia.software.hackatona.pucrs.controller.dto;

import engenharia.software.hackatona.pucrs.model.AvaliacaoModel;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliacaoDTO implements Serializable {

    private Integer id;
    private Integer softwareFuncionando;
    private Integer processo;
    private Integer pictch;
    private Integer inovacao;
    private Integer formacaoTime;

    public AvaliacaoDTO(AvaliacaoModel avaliacaoModel) {
        this.id = avaliacaoModel.getId();
        this.softwareFuncionando = avaliacaoModel.getSoftwareFuncionando();
        this.processo = avaliacaoModel.getProcesso();
        this.pictch = avaliacaoModel.getPictch();
        this.inovacao = avaliacaoModel.getInovacao();
        this.formacaoTime = avaliacaoModel.getFormacaoTime();
    }

    public AvaliacaoDTO(Integer softwareFuncionando, Integer processo, Integer pictch, Integer inovacao, Integer formacaoTime) {
        this.softwareFuncionando = softwareFuncionando;
        this.processo = processo;
        this.pictch = pictch;
        this.inovacao = inovacao;
        this.formacaoTime = formacaoTime;
    }

}
