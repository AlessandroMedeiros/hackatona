package engenharia.software.hackatona.observer;

import engenharia.software.hackatona.observer.event.DeletarAlunoDoTimeEvent;
import engenharia.software.hackatona.pucrs.service.AlunoService;

public class ObserverModule implements DeletarAlunoDoTimeObserver {

	private AlunoService service;
	
	public void updateInstance(AlunoService instance) {
		this.service = instance;
	}
	
	@Override
	public void deletarDoTime(DeletarAlunoDoTimeEvent event) {
		
		System.out.println("ObserverModule class.");
		this.service.removerTimeDeAluno(event.getAluno().getId());
		
	}

}
