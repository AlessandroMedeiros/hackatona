package engenharia.software.hackatona.pucrs.controller;


import engenharia.software.hackatona.pucrs.model.TimeModel;
import engenharia.software.hackatona.pucrs.service.ConferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conferencia")
public class ConferenciaController {

    @Autowired
    private ConferenciaService conferenciaService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<TimeModel> validarConferencia(@PathVariable Integer id){
        boolean valido =  conferenciaService.validarTime(id);
        if(valido){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
