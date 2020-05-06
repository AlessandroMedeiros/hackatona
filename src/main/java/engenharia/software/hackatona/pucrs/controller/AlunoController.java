package engenharia.software.hackatona.pucrs.controller;

import engenharia.software.hackatona.pucrs.controller.DTO.AlunoDTO;
import engenharia.software.hackatona.pucrs.controller.DTO.NovoAlunoDTO;
import engenharia.software.hackatona.pucrs.model.AlunoModel;
import engenharia.software.hackatona.pucrs.repository.AlunoRepository;
import engenharia.software.hackatona.pucrs.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

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
}
