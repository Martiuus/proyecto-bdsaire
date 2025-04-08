package pe.edu.idat.proyecto_bdsaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.idat.proyecto_bdsaire.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {
    UsuarioModel findTopByOrderByUsuarioidDesc();

    @Query(value = "SELECT usuarioid FROM usuario ORDER BY usuarioid DESC LIMIT 1", nativeQuery = true)
    String findUltimoId();
}