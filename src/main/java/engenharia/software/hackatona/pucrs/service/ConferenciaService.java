package engenharia.software.hackatona.pucrs.service;

import engenharia.software.hackatona.pucrs.model.AlunoModel;
import engenharia.software.hackatona.pucrs.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenciaService {

    @Autowired
    private AlunoRepository alunoRepository;

    public boolean validarTime(Integer idTime){

        List<AlunoModel> listaAlunos = alunoRepository.findAll();
        List<AlunoModel> novaLista = new ArrayList<>();

        for(int i=0; i<listaAlunos.size(); i++){
            boolean aux = listaAlunos.get(i).getTime().getId().equals(idTime);
            if(aux){
                novaLista.add(listaAlunos.get(i));
            }
        }

        for(int i=0; i<novaLista.size(); i++){
            for(int j=0; j<novaLista.size(); j++){
                if(!novaLista.get(i).getCurso().equals(novaLista.get(j).getCurso())){
                    System.out.println("Grupo eh valido // arrumar");
                    return true;
                }
            }
        }
        System.out.println("Grupo não é valido // arrumar");
        return false;
    }
}
