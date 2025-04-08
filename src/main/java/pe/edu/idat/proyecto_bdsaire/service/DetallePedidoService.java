package pe.edu.idat.proyecto_bdsaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.proyecto_bdsaire.model.DetallePedidoModel;
import pe.edu.idat.proyecto_bdsaire.repository.DetallePedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedidoModel> obtenerDetalles() {
        return detallePedidoRepository.findAll();
    }

    public Optional<DetallePedidoModel> obtenerPorId(Integer id) {
        return detallePedidoRepository.findById(id);
    }

    public void guardar(DetallePedidoModel detalle) {
        detallePedidoRepository.save(detalle);
    }

    public void eliminar(Integer id) {
        detallePedidoRepository.deleteById(id);
    }
}
