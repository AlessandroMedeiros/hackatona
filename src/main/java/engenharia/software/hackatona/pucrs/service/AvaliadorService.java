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
    private AvaliadorRepository avaliadorRepository;

    public List<AvaliadorModel> listarAvaliadores() {
        List<AvaliadorModel> listaAvaliadores = avaliadorRepository.findAll();
        return listaAvaliadores;
    }

    public AvaliadorModel adicionarAvaliador(NovoAvaliadorDTO novoAvaliadorDTO) {
        AvaliadorModel avaliadorModel = new AvaliadorModel(novoAvaliadorDTO.getId(), novoAvaliadorDTO.getNome(), novoAvaliadorDTO.getEmail());
        avaliadorModel = avaliadorRepository.save(avaliadorModel);
        return avaliadorModel;
    }


    public boolean deletarAvaliador(Integer id){
        List<AvaliadorModel> avaliadores = listarAvaliadores();
        AvaliadorModel avaliador = avaliadores.stream().filter(a -> a.getId().equals(id)).findFirst().get();
        if(avaliador!=null){
            avaliadorRepository.delete(avaliador);
            return true;
        }
        return false;
    }
}
