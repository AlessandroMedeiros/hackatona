package engenharia.software.hackatona.pucrs.controller.dto;

import engenharia.software.hackatona.pucrs.model.TimeModel;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TimeDTO implements Serializable {

    private Integer id;
    private String nome;

    public TimeDTO(TimeModel timeModel) {
        this.id = timeModel.getId();
        this.nome = timeModel.getNome();
    }

}
