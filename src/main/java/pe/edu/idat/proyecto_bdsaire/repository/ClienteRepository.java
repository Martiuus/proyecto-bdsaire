package pe.edu.idat.proyecto_bdsaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.proyecto_bdsaire.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel,Integer> {
    long count();
}
