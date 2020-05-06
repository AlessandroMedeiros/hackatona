package engenharia.software.hackatona.pucrs.repository;

import engenharia.software.hackatona.pucrs.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<AlunoModel, Integer> {

    Optional<AlunoModel> findByNome(String nome);

    Optional<AlunoModel> findById(Integer id);
}
