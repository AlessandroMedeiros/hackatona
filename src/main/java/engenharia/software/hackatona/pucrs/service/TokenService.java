package engenharia.software.hackatona.pucrs.service;

import engenharia.software.hackatona.pucrs.repository.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private AvaliadorRepository avaliadorRepository;

    public String recuperarToken(HttpHeaders request) {
        String token = request.get("Authorization").get(0);
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }
}
