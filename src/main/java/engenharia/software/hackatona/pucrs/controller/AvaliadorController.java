package engenharia.software.hackatona.pucrs.controller;

import engenharia.software.hackatona.pucrs.controller.DTO.AlunoDTO;
import engenharia.software.hackatona.pucrs.controller.DTO.AvaliadorDTO;
import engenharia.software.hackatona.pucrs.controller.DTO.NovoAvaliadorDTO;
import engenharia.software.hackatona.pucrs.model.AvaliadorModel;
import engenharia.software.hackatona.pucrs.repository.AvaliadorRepository;
import engenharia.software.hackatona.pucrs.service.AvaliadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/avaliadores")
public class AvaliadorController {

    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @Autowired
    private AvaliadorService avaliadorService;

    @GetMapping
    public List<AvaliadorModel> listarAvaliadores() {
        return avaliadorService.listarAvaliadores();
    }

    @PostMapping
    public ResponseEntity<AvaliadorModel> adicionarAvaliador(@RequestBody NovoAvaliadorDTO novoAvaliadorDTO) {
        AvaliadorModel avaliadorModel = avaliadorService.adicionarAvaliador(novoAvaliadorDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaliadorModel.getId()).toUri();
        return ResponseEntity.created(uri).body(avaliadorModel);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AvaliadorModel> deletarAvaliador(@PathVariable Integer id){
        boolean isDeleted = avaliadorService.deletarAvaliador(id);
        if(isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
