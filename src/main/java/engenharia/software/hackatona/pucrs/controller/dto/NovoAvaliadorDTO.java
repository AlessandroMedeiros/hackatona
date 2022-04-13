package engenharia.software.hackatona.pucrs.controller.dto;

import java.io.Serializable;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
