package engenharia.software.hackatona.pucrs.service;

import engenharia.software.hackatona.pucrs.controller.dto.NovoTimeDTO;
import engenharia.software.hackatona.pucrs.model.TimeModel;
import engenharia.software.hackatona.pucrs.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean deletarTime(Integer id) {
        List<TimeModel> times = listarTimes();
        TimeModel time = times
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .get();
        if (time != null) {
            timeRepository.delete(time);
            return true;
        }
        return false;
    }
}
