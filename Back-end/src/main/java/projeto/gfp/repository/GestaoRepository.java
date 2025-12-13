package projeto.gfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.gfp.models.GestaoFinanceiraModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface GestaoRepository extends JpaRepository<GestaoFinanceiraModel, Long> {
    Optional<GestaoFinanceiraModel> findByCdGestao (Long cdGestao);

    List<GestaoFinanceiraModel> findByCdUsuarioCdUsuario (Long  cdUsuario);
}
