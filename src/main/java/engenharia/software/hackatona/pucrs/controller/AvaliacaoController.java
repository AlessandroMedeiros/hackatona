package engenharia.software.hackatona.pucrs.controller;


import engenharia.software.hackatona.pucrs.controller.dto.NovaAvaliacaoDTO;
import engenharia.software.hackatona.pucrs.model.AvaliacaoModel;
import engenharia.software.hackatona.pucrs.service.AvaliacaoService;
import engenharia.software.hackatona.pucrs.service.AvaliadorService;
import engenharia.software.hackatona.pucrs.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    private AvaliacaoService avaliacaoService;

    @Autowired
    private AvaliadorService avaliadorService;

    @GetMapping
    public List<AvaliacaoModel> listarAvaliacoes() {
        return avaliacaoService.listarAvaliacoes();
    }

    @PostMapping
    public ResponseEntity<AvaliacaoModel> adicionarAvaliacao(@RequestBody NovaAvaliacaoDTO novaAvaliacaoDTO, @RequestHeader HttpHeaders headers) {
        TokenService tokenService = new TokenService();
        String token = tokenService.recuperarToken(headers);
        boolean achouUsuario = avaliadorService.getUsuario(token);
        if (achouUsuario) {
            AvaliacaoModel avaliacaoModel = avaliacaoService.adicionarAvaliacao(novaAvaliacaoDTO);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaliacaoModel.getId()).toUri();
            return ResponseEntity.created(uri).body(avaliacaoModel);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AvaliacaoModel> deletarAvaliacao(@PathVariable Integer id) {
        boolean isDeleted = avaliacaoService.deletarAvaliacao(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
