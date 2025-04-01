package pe.edu.idat.proyecto_bdsaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.proyecto_bdsaire.model.CategoriaModel;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Integer> {
}
