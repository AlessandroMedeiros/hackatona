package engenharia.software.hackatona.pucrs.service;

import engenharia.software.hackatona.pucrs.controller.DTO.NovoAlunoDTO;
import engenharia.software.hackatona.pucrs.model.AlunoModel;
import engenharia.software.hackatona.pucrs.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoModel> listarAlunos() {
        List<AlunoModel> listaAlunos = alunoRepository.findAll();
        return listaAlunos;
    }

    public AlunoModel adicionarAluno(NovoAlunoDTO novoAlunoDTO) {
        AlunoModel alunoModel = new AlunoModel(novoAlunoDTO.getId(), novoAlunoDTO.getNome(), novoAlunoDTO.getCurso());
        alunoModel = alunoRepository.save(alunoModel);
        return alunoModel;
    }


    public boolean deletarAluno(Integer id){
        List<AlunoModel> time = listarAlunos();
        //Implementar com java 8 stream, lambda, filter e forEach
        //time.stream().filter(t -> t.equals(id)).
        for(int i=0; i<time.size(); i++){
            if(time.get(i).getId().equals(id)){
                alunoRepository.delete(time.get(i));
                return true;
            }
        }
        return false;
    }
}
