package projeto.gfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.gfp.models.TipoModel;

import java.util.Optional;

@Repository
public interface TipoRepository extends JpaRepository<TipoModel, Long> {
    Optional<TipoModel> findByCdTipo (Long cdTipo);
}
