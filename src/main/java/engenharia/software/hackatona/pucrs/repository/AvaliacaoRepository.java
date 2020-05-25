package engenharia.software.hackatona.pucrs.repository;

import engenharia.software.hackatona.pucrs.model.AvaliacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoModel, Integer> {

    Optional<AvaliacaoModel> findById(Integer id);
}