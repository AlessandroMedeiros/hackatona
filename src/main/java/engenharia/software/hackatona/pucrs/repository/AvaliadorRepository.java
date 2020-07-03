package engenharia.software.hackatona.pucrs.repository;

import engenharia.software.hackatona.pucrs.model.AvaliadorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvaliadorRepository extends JpaRepository<AvaliadorModel, Integer> {

        Optional<AvaliadorModel> findByNome(String nome);

        Optional<AvaliadorModel> findById(Integer id);
}
