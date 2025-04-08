package pe.edu.idat.proyecto_bdsaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.proyecto_bdsaire.model.ProveedorModel;

public interface ProveedorRepository extends JpaRepository<ProveedorModel, Integer> {
    long count();
}