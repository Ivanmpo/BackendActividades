package com.tienda.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tienda.data.models.Usuario;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long>{

	List<Usuario> findAll();
}
