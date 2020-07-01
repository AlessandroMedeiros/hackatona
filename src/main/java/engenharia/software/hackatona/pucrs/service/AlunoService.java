package engenharia.software.hackatona.pucrs.service;

import engenharia.software.hackatona.observer.DeletarAlunoDoTimeObserver;
import engenharia.software.hackatona.observer.DeletarObserver;
import engenharia.software.hackatona.observer.ObserverModule;
import engenharia.software.hackatona.observer.event.DeletarAlunoDoTimeEvent;
import engenharia.software.hackatona.pucrs.controller.DTO.NovoAlunoDTO;
import engenharia.software.hackatona.pucrs.model.AlunoModel;
import engenharia.software.hackatona.pucrs.model.TimeModel;
import engenharia.software.hackatona.pucrs.repository.AlunoRepository;
import engenharia.software.hackatona.pucrs.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TimeRepository timeRepository;

    public List<AlunoModel> listarAlunos() {
        List<AlunoModel> listaAlunos = alunoRepository.findAll();
        return listaAlunos;
    }

    public AlunoModel adicionarAluno(NovoAlunoDTO novoAlunoDTO) {
        AlunoModel alunoModel = new AlunoModel(novoAlunoDTO.getId(), novoAlunoDTO.getNome(), novoAlunoDTO.getCurso(), novoAlunoDTO.getTime());
        alunoModel = alunoRepository.save(alunoModel);
        return alunoModel;
    }

    public boolean deletarAluno(Integer id){
    	
        List<AlunoModel> alunos = listarAlunos();
        AlunoModel aluno = alunos.stream().filter(a -> a.getId().equals(id)).findFirst().get();
       
		DeletarObserver.getInstance().addProdutoDescontoObserver(new ObserverModule(this));
        
        if(aluno!=null){
        	
        	DeletarAlunoDoTimeEvent event = new DeletarAlunoDoTimeEvent(aluno);
        	
        	for(DeletarAlunoDoTimeObserver observerObject : DeletarObserver.getInstance().getObserver()) {
        		observerObject.deletarDoTime(event);
        	}
        	
            alunoRepository.delete(aluno);
            return true;
        }
        
        
        
        return false;
    }

    public boolean adicionarAlunosEmTimes(Integer idTime, ArrayList<Integer> lista){
        for(int i=0; i<lista.size(); i++){
            Optional<AlunoModel> aluno = alunoRepository.findById(lista.get(i));
            Optional<TimeModel> time = timeRepository.findById(idTime);
            aluno.get().setTime(time.get());
            alunoRepository.save(aluno.get());
        }
        return true;
    }

    public boolean removerTimeDeAluno(ArrayList<Integer> lista){
        for(int i=0; i<lista.size(); i++){
            Optional<AlunoModel> aluno = alunoRepository.findById(lista.get(i));
            aluno.get().setTime(null);
            alunoRepository.save(aluno.get());
        }
        return true;
    }
    
    public boolean removerTimeDeAluno(Integer id) {
    	Optional<AlunoModel> aluno = alunoRepository.findById(id);
    	aluno.get().setTime(null);
    	alunoRepository.save(aluno.get());
    	
    	return true;
    }
}
