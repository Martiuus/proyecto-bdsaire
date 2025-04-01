package pe.edu.idat.proyecto_bdsaire.service;

import pe.edu.idat.proyecto_bdsaire.model.OrdenFinalModel;
import pe.edu.idat.proyecto_bdsaire.repository.OrdenFinalRepository;

import java.util.List;

public class OrdenFinalService {
    private final OrdenFinalRepository ordenFinalRepository;

    public OrdenFinalService(OrdenFinalRepository ordenFinalRepository) {
        this.ordenFinalRepository = ordenFinalRepository;
    }

    public List<OrdenFinalModel> obtenerOrdenFinal(){
        return ordenFinalRepository.findAll();
    }

    public void guardarOrdenFinal(OrdenFinalModel ordenfinal){
        ordenFinalRepository.save(ordenfinal);
    }
}
