package engenharia.software.hackatona.pucrs.controller.DTO;

import engenharia.software.hackatona.pucrs.model.TimeModel;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NovoAlunoDTO implements Serializable {

    private Integer id;
    private String nome;
    private String curso;
    private TimeModel time;

    public NovoAlunoDTO() {
    }

    public NovoAlunoDTO(Integer id, String nome, String curso, TimeModel time) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.time = time;
    }
}
