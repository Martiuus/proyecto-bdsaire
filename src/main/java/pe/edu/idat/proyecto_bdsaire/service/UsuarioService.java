package pe.edu.idat.proyecto_bdsaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.proyecto_bdsaire.model.UsuarioModel;
import pe.edu.idat.proyecto_bdsaire.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> obtenerPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public void guardarUsuario(UsuarioModel usuario) {
        usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }

    public String generarNuevoId() {
        UsuarioModel ultimo = usuarioRepository.findTopByOrderByUsuarioidDesc();
        if (ultimo == null) {
            return "PE00001";
        }
        int num = Integer.parseInt(ultimo.getUsuarioid().substring(2)) + 1;
        return String.format("PE%05d", num);
    }
}
