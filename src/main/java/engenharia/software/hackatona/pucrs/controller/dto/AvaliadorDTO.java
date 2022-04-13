package engenharia.software.hackatona.pucrs.controller.dto;

import engenharia.software.hackatona.pucrs.model.AvaliadorModel;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

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


}
