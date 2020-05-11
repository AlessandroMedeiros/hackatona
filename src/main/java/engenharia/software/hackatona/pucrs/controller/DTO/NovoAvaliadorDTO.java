package engenharia.software.hackatona.pucrs.controller.DTO;

import java.io.Serializable;

public class NovoAvaliadorDTO implements Serializable{

    private Integer id;
    private String nome;

    public NovoAvaliadorDTO() {
    }

    public NovoAvaliadorDTO(Integer id, String nome) {
        this.id = id;
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
