package engenharia.software.hackatona.pucrs.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "aluno")
public class AlunoModel implements Serializable {

    public AlunoModel() {
    }

    public AlunoModel(Integer id, String nome, String curso, TimeModel time) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
        this.time = time;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "curso")
    private String curso;

    @ManyToOne
    private TimeModel time;


}
