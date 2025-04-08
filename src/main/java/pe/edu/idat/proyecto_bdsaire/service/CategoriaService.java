package pe.edu.idat.proyecto_bdsaire.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.proyecto_bdsaire.model.CategoriaModel;
import pe.edu.idat.proyecto_bdsaire.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaModel> listar() {
        return categoriaRepository.findAll();
    }

    public CategoriaModel guardar(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    public Optional<CategoriaModel> buscarPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    public void eliminar(Integer id) {
        categoriaRepository.deleteById(id);
    }
}