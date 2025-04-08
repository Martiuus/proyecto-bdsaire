package pe.edu.idat.proyecto_bdsaire.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.proyecto_bdsaire.model.UbicacionModel;
import pe.edu.idat.proyecto_bdsaire.repository.UbicacionRepository;

import java.util.List;

@Service
public class UbicacionService {

    private final UbicacionRepository ubicacionRepository;

    public UbicacionService(UbicacionRepository ubicacionRepository) {
        this.ubicacionRepository = ubicacionRepository;
    }

    public List<UbicacionModel> listarTodo() {
        return ubicacionRepository.findAll();
    }

    public UbicacionModel buscarPorId(Integer id) {
        return ubicacionRepository.findById(id).orElse(null);
    }

    public void guardar(UbicacionModel ubicacion) {
        ubicacionRepository.save(ubicacion);
    }

    public void eliminar(Integer id) {
        ubicacionRepository.deleteById(id);
    }
}