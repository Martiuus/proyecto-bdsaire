package pe.edu.idat.proyecto_bdsaire.service;

import pe.edu.idat.proyecto_bdsaire.model.LoteModel;
import pe.edu.idat.proyecto_bdsaire.repository.LoteRepository;

import java.util.List;

public class LoteService {
    private final LoteRepository loteRepository;

    public LoteService(LoteRepository loteRepository) {
        this.loteRepository = loteRepository;
    }

    public List<LoteModel> obtenerLote(){
        return loteRepository.findAll();
    }

    public void guardarLote(LoteModel lote){
        loteRepository.save(lote);
    }
}
