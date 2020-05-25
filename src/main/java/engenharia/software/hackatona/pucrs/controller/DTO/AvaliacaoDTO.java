package engenharia.software.hackatona.pucrs.controller.DTO;

import engenharia.software.hackatona.pucrs.model.AvaliacaoModel;

import java.io.Serializable;

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
