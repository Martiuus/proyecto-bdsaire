package pe.edu.idat.proyecto_bdsaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.idat.proyecto_bdsaire.model.PedidoModel;

public interface PedidoRepository extends JpaRepository<PedidoModel,Integer> {
}
