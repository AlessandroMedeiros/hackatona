package engenharia.software.hackatona.pucrs.service;

import engenharia.software.hackatona.pucrs.controller.DTO.NovoAvaliadorDTO;
import engenharia.software.hackatona.pucrs.model.AvaliadorModel;
import engenharia.software.hackatona.pucrs.repository.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliadorService {

    @Autowired
    private AvaliadorRepository avalidorRepository;

    public List<AvaliadorModel> listarAvaliadores() {
        List<AvaliadorModel> listaAvaliadores = avalidorRepository.findAll();
        return listaAvaliadores;
    }

    public AvaliadorModel adicionarAvaliador(NovoAvaliadorDTO novoAvaliadorDTO) {
        AvaliadorModel avaliadorModel = new AvaliadorModel(novoAvaliadorDTO.getId(), novoAvaliadorDTO.getNome());
        avaliadorModel = avalidorRepository.save(avaliadorModel);
        return avaliadorModel;
    }


    public boolean deletarAvaliador(Integer id){
        List<AvaliadorModel> time = listarAvaliadores();
        //Implementar com java 8 stream, lambda, filter e forEach
        //time.stream().filter(t -> t.equals(id)).
        for(int i=0; i<time.size(); i++){
            if(time.get(i).getId().equals(id)){
                avalidorRepository.delete(time.get(i));
                return true;
            }
        }
        return false;
    }
}
