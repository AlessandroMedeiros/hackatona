package engenharia.software.hackatona.pucrs.controller.DTO;

import engenharia.software.hackatona.pucrs.model.AlunoModel;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
