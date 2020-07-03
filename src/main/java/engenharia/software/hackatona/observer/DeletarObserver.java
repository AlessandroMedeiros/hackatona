package engenharia.software.hackatona.observer;

import java.util.ArrayList;
import java.util.List;

public class DeletarObserver extends Thread {
	
	private List<DeletarAlunoDoTimeObserver> observer = new ArrayList<>();
	
	private static DeletarObserver instance;
	
	public static DeletarObserver getInstance() {
		if(instance == null) {
			instance = new DeletarObserver();
		}
		
		return instance;
	}
	
	public void addDeletarAlunoDoTimeObserver(DeletarAlunoDoTimeObserver observer) {		
		this.observer.add(observer);
	}
	
	public List<DeletarAlunoDoTimeObserver> getObserver() {
		return observer;
	}



	public void setObserver(List<DeletarAlunoDoTimeObserver> observer) {
		this.observer = observer;
	}

	@Override
	public void run() { }
	
}
