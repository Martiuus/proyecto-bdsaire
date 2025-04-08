package pe.edu.idat.proyecto_bdsaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.idat.proyecto_bdsaire.model.DetallePedidoModel;

import java.util.List;

public interface DetallePedidoRepository extends JpaRepository<DetallePedidoModel, Integer> {
    @Query("SELECT d FROM DetallePedidoModel d ORDER BY d.detallepedidoid DESC LIMIT 5")
    List<DetallePedidoModel> findTop5ByOrderByIdDesc();
    long count();
}