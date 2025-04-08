package pe.edu.idat.proyecto_bdsaire.service;


import org.springframework.stereotype.Service;
import pe.edu.idat.proyecto_bdsaire.model.ProveedorModel;
import pe.edu.idat.proyecto_bdsaire.repository.ProveedorRepository;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public List<ProveedorModel> obtenerProveedores() {
        return proveedorRepository.findAll();
    }

    public void guardarProveedor(ProveedorModel proveedor) {
        proveedorRepository.save(proveedor);
    }

    public ProveedorModel obtenerProveedorPorId(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public void eliminarProveedor(Integer id) {
        proveedorRepository.deleteById(id);
    }
}