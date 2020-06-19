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
        AlunoModel alunoModel = new AlunoModel(novoAlunoDTO.getId(), novoAlunoDTO.getNome(), novoAlunoDTO.getCurso(), novoAlunoDTO.getTime());
        alunoModel = alunoRepository.save(alunoModel);
        return alunoModel;
    }


    public boolean deletarAluno(Integer id){
        List<AlunoModel> alunos = listarAlunos();

        AlunoModel al = alunos
                .stream()
                .filter(a -> a.equals(id))
                .findFirst()
                .get();

        if(al!=null){
            alunoRepository.delete(al);
            return true;
        }else return false;
    }
}
