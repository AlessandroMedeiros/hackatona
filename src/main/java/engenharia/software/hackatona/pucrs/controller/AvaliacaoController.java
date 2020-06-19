package engenharia.software.hackatona.pucrs.controller;


import engenharia.software.hackatona.pucrs.controller.DTO.AvaliacaoDTO;
import engenharia.software.hackatona.pucrs.controller.DTO.NovaAvaliacaoDTO;
import engenharia.software.hackatona.pucrs.model.AvaliacaoModel;
import engenharia.software.hackatona.pucrs.repository.AvaliacaoRepository;
import engenharia.software.hackatona.pucrs.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<AvaliacaoModel> listarAvaliacoes() {
        return avaliacaoService.listarAvaliacoes();
    }

    @PostMapping
    public ResponseEntity<AvaliacaoDTO> adicionarAvaliacao(@RequestBody NovaAvaliacaoDTO novaAvaliacaoDTO) {
        AvaliacaoModel avaliacaoModel = avaliacaoService.adicionarAvaliacao(novaAvaliacaoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaliacaoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(new AvaliacaoDTO(avaliacaoModel));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AvaliacaoModel> deletarAvaliacao(@PathVariable Integer id){
        boolean isDeleted = avaliacaoService.deletarAvaliacao(id);
        if(isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
