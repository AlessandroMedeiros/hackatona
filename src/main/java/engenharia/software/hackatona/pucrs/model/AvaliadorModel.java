package engenharia.software.hackatona.pucrs.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "avaliador")
public class AvaliadorModel implements Serializable {

    public AvaliadorModel() {
    }

    public AvaliadorModel(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "email")
    private String email;
}
