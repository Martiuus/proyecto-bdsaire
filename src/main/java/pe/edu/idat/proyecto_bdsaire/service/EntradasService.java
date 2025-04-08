package pe.edu.idat.proyecto_bdsaire.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.proyecto_bdsaire.model.EntradasModel;
import pe.edu.idat.proyecto_bdsaire.repository.EntradasRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EntradasService {
    private final EntradasRepository entradasRepository;

    public EntradasService(EntradasRepository entradasRepository) {
        this.entradasRepository = entradasRepository;
    }

    public List<EntradasModel> obtenerEntradas(){
        return entradasRepository.findAll();
    }

    public void guardarEntradas(EntradasModel entrada){
        entradasRepository.save(entrada);
    }

    public Optional<EntradasModel> obtenerPorId(Integer id) {
        return entradasRepository.findById(id);
    }

}
