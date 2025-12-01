package projeto.gfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto.gfp.models.StatusModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<StatusModel, Long> {
    Optional<StatusModel> findByCdStatus (Long cdStatus);
}
