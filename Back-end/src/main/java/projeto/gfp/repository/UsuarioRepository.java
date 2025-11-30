package projeto.gfp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projeto.gfp.models.UsuarioModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByDsEmail (String dsEmail);
    Optional<UsuarioModel> findByCdUsuario (Long cdUsuario);

    @Query("select u from UsuarioModel u where u.flAtivo = true")
    List<UsuarioModel> findAllByFlAtivo();
}
