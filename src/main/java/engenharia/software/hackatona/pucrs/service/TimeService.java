package engenharia.software.hackatona.pucrs.service;

import engenharia.software.hackatona.pucrs.controller.DTO.NovoAlunoDTO;
import engenharia.software.hackatona.pucrs.controller.DTO.NovoTimeDTO;
import engenharia.software.hackatona.pucrs.model.AlunoModel;
import engenharia.software.hackatona.pucrs.model.TimeModel;
import engenharia.software.hackatona.pucrs.repository.AlunoRepository;
import engenharia.software.hackatona.pucrs.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public List<TimeModel> listarTimes() {
        List<TimeModel> listaTimes = timeRepository.findAll();
        return listaTimes;
    }

    public TimeModel adicionarTime(NovoTimeDTO novoTimeDTO) {
        TimeModel timeModel = new TimeModel(novoTimeDTO.getId(), novoTimeDTO.getNome());
        timeModel = timeRepository.save(timeModel);
        return timeModel;
    }

    public boolean deletarTime(Integer id){
        List<TimeModel> times = listarTimes();

        TimeModel time = times
                        .stream()
                        .filter(t -> t.equals(id))
                        .findFirst()
                        .get();

        if(time!=null){
            timeRepository.delete(time);
            return true;
        }else return false;
    }

    public static void main(String args[]){

    }
}
