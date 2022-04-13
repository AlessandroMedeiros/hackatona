package engenharia.software.hackatona.observer.event;

import engenharia.software.hackatona.pucrs.model.AlunoModel;


public class DeletarAlunoDoTimeEvent {

    private final AlunoModel aluno;

    public DeletarAlunoDoTimeEvent(AlunoModel aluno) {
        this.aluno = aluno;
    }

    public AlunoModel getAluno() {
        return aluno;
    }
}
