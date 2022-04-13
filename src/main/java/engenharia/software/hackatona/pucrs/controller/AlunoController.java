package engenharia.software.hackatona.pucrs.controller;

import engenharia.software.hackatona.pucrs.controller.dto.AlunoDTO;
import engenharia.software.hackatona.pucrs.controller.dto.AlunosTimesDTO;
import engenharia.software.hackatona.pucrs.controller.dto.NovoAlunoDTO;
import engenharia.software.hackatona.pucrs.model.AlunoModel;
import engenharia.software.hackatona.pucrs.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<AlunoModel> adicionarAluno(@RequestBody NovoAlunoDTO novoAlunoDTO) {
        AlunoModel alunoModel = alunoService.adicionarAluno(novoAlunoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(alunoModel);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AlunoDTO> deletarAluno(@PathVariable Integer id) {
        boolean isDeleted = alunoService.deletarAluno(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/adicionarAlunosEmTimes")
    public ResponseEntity<AlunoModel> adicionarAlunosEmTimes(@RequestBody AlunosTimesDTO alunosTimesDTO) {
        boolean adionado = alunoService.adicionarAlunosEmTimes(alunosTimesDTO.getIdTime(), alunosTimesDTO.getLista());
        if (adionado) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(path = "/removerTimeDeAluno")
    public ResponseEntity<AlunoModel> removerTimeDeAluno(@RequestBody AlunosTimesDTO alunosTimesDTO) {
        boolean removido = alunoService.removerTimeDeAluno(alunosTimesDTO.getLista());
        if (removido) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
