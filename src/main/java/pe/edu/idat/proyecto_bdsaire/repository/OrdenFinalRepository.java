package pe.edu.idat.proyecto_bdsaire.repository;

import pe.edu.idat.proyecto_bdsaire.model.EstadoOrden;
import pe.edu.idat.proyecto_bdsaire.model.OrdenFinalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdenFinalRepository extends JpaRepository<OrdenFinalModel, Integer> {
    List<OrdenFinalModel> findByEstadoNot(EstadoOrden estado);  // 👈 Importante usar enum aquí también
}
