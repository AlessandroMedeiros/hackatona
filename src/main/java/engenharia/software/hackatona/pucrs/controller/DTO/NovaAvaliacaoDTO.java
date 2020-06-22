package engenharia.software.hackatona.pucrs.controller.DTO;

import engenharia.software.hackatona.pucrs.model.AvaliadorModel;
import engenharia.software.hackatona.pucrs.model.TimeModel;

import java.io.Serializable;

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

    public AvaliadorModel getAvaliadorModel() {
        return avaliadorModel;
    }

    public void setAvaliadorModel(AvaliadorModel avaliadorModel) {
        this.avaliadorModel = avaliadorModel;
    }

    public TimeModel getTimeModel() {
        return timeModel;
    }

    public void setTimeModel(TimeModel timeModel) {
        this.timeModel = timeModel;
    }
}
