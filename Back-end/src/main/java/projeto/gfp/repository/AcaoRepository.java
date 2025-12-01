package projeto.gfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.gfp.models.AcaoFinanceiraModel;

import java.util.Optional;

@Repository
public interface AcaoRepository extends JpaRepository<AcaoFinanceiraModel, Long> {
    Optional<AcaoFinanceiraModel> findByCdAcao (Long cdAcao);
}
