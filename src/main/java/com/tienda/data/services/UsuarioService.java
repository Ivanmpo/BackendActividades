package com.tienda.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.tienda.data.models.Usuario;
import com.tienda.data.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private final UsuarioRepository usuarioRepo;
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepo = usuarioRepository;
	}
	
	public Usuario crearUsuario(@Valid Usuario usuario) {
		return usuarioRepo.save(usuario);
	}

	public List<Usuario> findAll() {
		return usuarioRepo.findAll();
	}
	
	public void eliminarUsuario(Long id) {
		usuarioRepo.deleteById(id);
	}

	public Usuario buscarUsuario(Long id) {
		Optional<Usuario> oUsuario = usuarioRepo.findById(id);
		if(oUsuario.isPresent()) {
			return oUsuario.get();
		}
		return null;
	}

	public void modificarUsuario(@Valid Usuario usuario) {
		usuarioRepo.save(usuario);
		
	}
}
