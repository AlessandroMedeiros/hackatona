package engenharia.software.hackatona.pucrs.controller.DTO;

import engenharia.software.hackatona.pucrs.model.TimeModel;

import java.io.Serializable;

public class TimeDTO implements Serializable {

    private Integer id;
    private String nome;

    public TimeDTO(TimeModel timeModel) {
        this.id = timeModel.getId();
        this.nome = timeModel.getNome();
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
