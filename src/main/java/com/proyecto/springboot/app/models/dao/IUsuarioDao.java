package com.proyecto.springboot.app.models.dao;

import java.util.List;

import com.proyecto.springboot.app.models.entity.Usuario;

public interface IUsuarioDao {

	public List<Usuario> findAll();

	public void save(Usuario usuario);
	
	public Usuario findOne(Long idusuario);
	
	public void delete(Long idusuario);

}
