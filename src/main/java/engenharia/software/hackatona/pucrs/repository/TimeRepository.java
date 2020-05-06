package engenharia.software.hackatona.pucrs.repository;

import engenharia.software.hackatona.pucrs.model.TimeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimeRepository extends JpaRepository<TimeModel, Integer> {


    Optional<TimeModel> findByNome(String nome);

    Optional<TimeModel> findById(Integer id);

}
