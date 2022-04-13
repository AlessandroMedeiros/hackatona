package engenharia.software.hackatona.pucrs.controller.dto;

import engenharia.software.hackatona.pucrs.model.AlunoModel;

import java.io.Serializable;

public class AlunoDTO implements Serializable {

    private Integer id;
    private String nome;
    private String curso;

    public AlunoDTO(AlunoModel alunoModel) {
        this.id = alunoModel.getId();
        this.nome = alunoModel.getNome();
        this.curso = alunoModel.getCurso();
    }

    public AlunoDTO(String nome, String curso) {
        this.nome = nome;
        this.curso = curso;
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
}
