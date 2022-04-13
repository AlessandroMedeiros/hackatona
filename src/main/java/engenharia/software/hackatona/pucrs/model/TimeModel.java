package engenharia.software.hackatona.pucrs.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "time")
public class TimeModel implements Serializable {

    public TimeModel() {
    }

    public TimeModel(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @Override
    public String toString() {
        return "id: " + this.id + " nome: " + this.nome;
    }
}
