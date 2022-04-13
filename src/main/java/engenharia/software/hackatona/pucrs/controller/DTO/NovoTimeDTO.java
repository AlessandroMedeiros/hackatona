package engenharia.software.hackatona.pucrs.controller.DTO;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NovoTimeDTO implements Serializable {

    private Integer id;
    private String nome;

    public NovoTimeDTO() {
    }

    public NovoTimeDTO(Integer id, String nome) {
        this.id = id;

        this.nome = nome;
    }


}
