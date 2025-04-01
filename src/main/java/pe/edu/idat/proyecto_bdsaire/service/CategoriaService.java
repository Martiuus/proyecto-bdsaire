package pe.edu.idat.proyecto_bdsaire.service;

import pe.edu.idat.proyecto_bdsaire.model.CategoriaModel;
import pe.edu.idat.proyecto_bdsaire.repository.CategoriaRepository;

import java.util.List;

public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaModel> obtenerCategoria() {
        return categoriaRepository.findAll();
    }

    public void guardarCategoria(CategoriaModel categoria) {
        categoriaRepository.save(categoria);
    }
}