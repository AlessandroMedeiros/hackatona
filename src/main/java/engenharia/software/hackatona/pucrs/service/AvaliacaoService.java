package engenharia.software.hackatona.pucrs.service;

import engenharia.software.hackatona.pucrs.controller.DTO.NovaAvaliacaoDTO;
import engenharia.software.hackatona.pucrs.controller.DTO.NovoAlunoDTO;
import engenharia.software.hackatona.pucrs.model.AlunoModel;
import engenharia.software.hackatona.pucrs.model.AvaliacaoModel;
import engenharia.software.hackatona.pucrs.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public List<AvaliacaoModel> listarAvaliacoes() {
        List<AvaliacaoModel> listarAvaliacoes = avaliacaoRepository.findAll();
        return listarAvaliacoes;
    }

    public AvaliacaoModel adicionarAvaliacao(NovaAvaliacaoDTO novaAvaliacaoDTO) {
        AvaliacaoModel avaliacaoModel = new AvaliacaoModel(novaAvaliacaoDTO.getId(), novaAvaliacaoDTO.getSoftwareFuncionando(), novaAvaliacaoDTO.getProcesso(), novaAvaliacaoDTO.getPictch(), novaAvaliacaoDTO.getInovacao(), novaAvaliacaoDTO.getFormacaoTime());
        avaliacaoModel = avaliacaoRepository.save(avaliacaoModel);
        return avaliacaoModel;
    }
}
