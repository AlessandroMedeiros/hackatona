package engenharia.software.hackatona.pucrs.controller;

import engenharia.software.hackatona.pucrs.controller.dto.NovoTimeDTO;
import engenharia.software.hackatona.pucrs.controller.dto.TimeDTO;
import engenharia.software.hackatona.pucrs.model.TimeModel;
import engenharia.software.hackatona.pucrs.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public List<TimeModel> listarTimes() {
        return timeService.listarTimes();
    }

    @PostMapping
    public ResponseEntity<TimeDTO> adicionarTime(@RequestBody NovoTimeDTO novoTimeDTO) {
        TimeModel timeModel = timeService.adicionarTime(novoTimeDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(timeModel.getId()).toUri();
        return ResponseEntity.created(uri).body(new TimeDTO(timeModel));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TimeModel> deletarTime(@PathVariable Integer id) {
        boolean isDeleted = timeService.deletarTime(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
