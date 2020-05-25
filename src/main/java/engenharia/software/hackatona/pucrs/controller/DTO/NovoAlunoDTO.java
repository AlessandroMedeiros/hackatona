package engenharia.software.hackatona.pucrs.controller.DTO;

import engenharia.software.hackatona.pucrs.model.TimeModel;

import java.io.Serializable;

public class NovoAlunoDTO implements Serializable {

    private Integer id;
    private String nome;
    private String curso;
    private TimeModel time;

    public NovoAlunoDTO(){}

    public NovoAlunoDTO(Integer id, String nome, String curso, TimeModel time) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.time = time;
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
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public TimeModel getTime() {
        return this.time;
    }

    public void setTime(TimeModel timeModel) {
        this.time = timeModel;
    }
}
