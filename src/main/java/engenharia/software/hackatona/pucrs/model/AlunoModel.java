package engenharia.software.hackatona.pucrs.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

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

    @NotNull
    @ManyToOne
    private TimeModel time;

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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public TimeModel getTime() {
        return time;
    }

    public void setTime(TimeModel time) {
        this.time = time;
    }
}
