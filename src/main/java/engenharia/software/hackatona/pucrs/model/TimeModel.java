package engenharia.software.hackatona.pucrs.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "time")
public class TimeModel implements Serializable {

    public TimeModel(){
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "time", fetch = FetchType.LAZY)
    private List<AlunoModel> alunos;

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

    public List<AlunoModel> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoModel> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "id: " + this.id + " nome: " + this.nome;
    }
}
