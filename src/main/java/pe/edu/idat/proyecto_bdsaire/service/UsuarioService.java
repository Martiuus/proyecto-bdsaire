package pe.edu.idat.proyecto_bdsaire.service;

import pe.edu.idat.proyecto_bdsaire.model.UsuarioModel;
import pe.edu.idat.proyecto_bdsaire.repository.UsuarioRepository;

import java.util.List;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioModel> obtenerUsuario(){
        return usuarioRepository.findAll();
    }

    public void guardarUsuario(UsuarioModel usuario){
        usuarioRepository.save(usuario);
    }
}
