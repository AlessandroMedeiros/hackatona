package engenharia.software.hackatona.pucrs.controller.DTO;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NovoAvaliadorDTO implements Serializable {

    private Integer id;
    private String nome;
    private String email;

    public NovoAvaliadorDTO() {
    }

    public NovoAvaliadorDTO(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
    }
}
