package pe.edu.idat.proyecto_bdsaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.idat.proyecto_bdsaire.model.ProductoModel;

import java.util.List;

public interface ProductoRepository extends JpaRepository<ProductoModel,Integer> {
    long count();

    @Query("SELECT p FROM ProductoModel p WHERE p.cantidad <= 100 ORDER BY p.cantidad ASC")
    List<ProductoModel> findProductosConBajoStock();
}
