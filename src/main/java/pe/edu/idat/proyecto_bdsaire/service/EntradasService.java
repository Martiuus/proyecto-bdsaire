package pe.edu.idat.proyecto_bdsaire.service;

import pe.edu.idat.proyecto_bdsaire.model.EntradasModel;
import pe.edu.idat.proyecto_bdsaire.repository.EntradasRepository;

import java.util.List;

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
}
