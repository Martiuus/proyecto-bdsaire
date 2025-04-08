package pe.edu.idat.proyecto_bdsaire.service;

import org.springframework.stereotype.Service;
import pe.edu.idat.proyecto_bdsaire.model.SalidaModel;
import pe.edu.idat.proyecto_bdsaire.repository.SalidaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalidaService {
    private final SalidaRepository salidaRepository;

    public SalidaService(SalidaRepository salidaRepository) {
        this.salidaRepository = salidaRepository;
    }

    public List<SalidaModel> obtenerSalidas() {
        return salidaRepository.findAll();
    }

    public void guardarSalida(SalidaModel salida) {
        salidaRepository.save(salida);
    }

    public Optional<SalidaModel> obtenerPorId(Integer id) {
        return salidaRepository.findById(id);
    }
}