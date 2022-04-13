package engenharia.software.hackatona.pucrs.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import engenharia.software.hackatona.pucrs.controller.dto.NovoAvaliadorDTO;
import engenharia.software.hackatona.pucrs.model.AvaliadorModel;
import engenharia.software.hackatona.pucrs.repository.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliadorService {

    @Autowired
    private AvaliadorRepository avaliadorRepository;

    public List<AvaliadorModel> listarAvaliadores() {
        List<AvaliadorModel> listaAvaliadores = avaliadorRepository.findAll();
        return listaAvaliadores;
    }

    public AvaliadorModel adicionarAvaliador(NovoAvaliadorDTO novoAvaliadorDTO) {
        AvaliadorModel avaliadorModel = new AvaliadorModel(novoAvaliadorDTO.getId(), novoAvaliadorDTO.getNome(), novoAvaliadorDTO.getEmail());
        avaliadorModel = avaliadorRepository.save(avaliadorModel);
        return avaliadorModel;
    }


    public boolean deletarAvaliador(Integer id) {
        List<AvaliadorModel> avaliadores = listarAvaliadores();
        AvaliadorModel avaliador = avaliadores.stream().filter(a -> a.getId().equals(id)).findFirst().get();
        if (avaliador != null) {
            avaliadorRepository.delete(avaliador);
            return true;
        }
        return false;
    }

    public boolean getUsuario(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String email = jwt.getClaims().get("email").asString();
        Optional<AvaliadorModel> avaliadorEmail = avaliadorRepository.findByEmail(email);
        return avaliadorEmail.isPresent();
    }
}
