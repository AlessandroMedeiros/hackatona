package engenharia.software.hackatona.pucrs.controller.DTO;

import engenharia.software.hackatona.pucrs.model.TimeModel;

import java.io.Serializable;

public class NovoAlunoDTO implements Serializable {

    private Integer id;
    private String nome;
    private String curso;
    private TimeModel timeModel;

    public NovoAlunoDTO(){}

    public NovoAlunoDTO(Integer id, String nome, String curso, TimeModel idTime) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.timeModel = timeModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public TimeModel getTimeModel() {
        return timeModel;
    }

    public void setTimeModel(TimeModel timeModel) {
        this.timeModel = timeModel;
    }
}
