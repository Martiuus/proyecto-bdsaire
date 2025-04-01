package pe.edu.idat.proyecto_bdsaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.proyecto_bdsaire.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel,Integer> {
}
