package engenharia.software.hackatona.pucrs.controller;

import engenharia.software.hackatona.pucrs.controller.DTO.AlunoDTO;
import engenharia.software.hackatona.pucrs.controller.DTO.AlunosTimesDTO;
import engenharia.software.hackatona.pucrs.controller.DTO.NovoAlunoDTO;
import engenharia.software.hackatona.pucrs.model.AlunoModel;
import engenharia.software.hackatona.pucrs.model.TimeModel;
import engenharia.software.hackatona.pucrs.repository.AlunoRepository;
import engenharia.software.hackatona.pucrs.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public List<AlunoModel> listarAlunos() {
        return alunoService.listarAlunos();
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> adicionarAluno(@RequestBody NovoAlunoDTO novoAlunoDTO) {
        AlunoModel usuarioModel = alunoService.adicionarAluno(novoAlunoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuarioModel.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDTO(usuarioModel));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TimeModel> deletarAluno(@PathVariable Integer id){
        boolean isDeleted = alunoService.deletarAluno(id);
        if(isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<TimeModel> adicionarAlunosEmTimes(@RequestBody AlunosTimesDTO alunosTimesDTO){
        boolean adionado = alunoService.adicionarAlunosEmTimes(alunosTimesDTO.getIdTime(), alunosTimesDTO.getLista());
        if(adionado) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
