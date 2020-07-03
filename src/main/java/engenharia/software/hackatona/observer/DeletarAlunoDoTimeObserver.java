package engenharia.software.hackatona.observer;

import engenharia.software.hackatona.observer.event.DeletarAlunoDoTimeEvent;

public interface DeletarAlunoDoTimeObserver {

    public void deletarDoTime(DeletarAlunoDoTimeEvent event);

}
