package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.proyecto.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();

	public Page<Usuario> findAll(Pageable pageable);
	
	public void save(Usuario usuario);
	
	public Usuario findOne(Long idusuario);
	
//	public Usuario findByIdUsuario(Long idusuario);
	
	public void delete(Long idusuario);
	
//	public Usuario findByUsername(String username);

	public Usuario  findByUsername(String name);


}
