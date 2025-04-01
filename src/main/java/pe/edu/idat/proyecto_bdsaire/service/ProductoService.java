package pe.edu.idat.proyecto_bdsaire.service;

import pe.edu.idat.proyecto_bdsaire.model.ProductoModel;
import pe.edu.idat.proyecto_bdsaire.repository.ProductoRepository;

import java.util.List;

public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoModel> obtenerProducto(){
        return productoRepository.findAll();
    }

    public void guardarProducto(ProductoModel producto){
        productoRepository.save(producto);
    }
}
