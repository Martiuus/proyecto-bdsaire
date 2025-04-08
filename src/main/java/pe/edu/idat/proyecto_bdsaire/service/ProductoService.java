package pe.edu.idat.proyecto_bdsaire.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.proyecto_bdsaire.model.ProductoModel;
import pe.edu.idat.proyecto_bdsaire.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoModel> listarTodos() {
        return productoRepository.findAll();
    }

    public Optional<ProductoModel> obtenerPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public void guardar(ProductoModel producto) {
        productoRepository.save(producto);
    }

    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }
}
