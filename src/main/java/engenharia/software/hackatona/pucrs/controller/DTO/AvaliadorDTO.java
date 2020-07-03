package engenharia.software.hackatona.pucrs.controller.DTO;

import engenharia.software.hackatona.pucrs.model.AvaliadorModel;

import java.io.Serializable;

public class AvaliadorDTO implements Serializable {

    private Integer id;
    private String nome;

    public AvaliadorDTO(AvaliadorModel avaliadorModel) {
        this.id = avaliadorModel.getId();
        this.nome = avaliadorModel.getNome();
    }

    public AvaliadorDTO(String nome) {
        this.nome = nome;
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
}
