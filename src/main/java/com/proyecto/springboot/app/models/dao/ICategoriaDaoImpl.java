package com.proyecto.springboot.app.models.dao;

import java.util.List;

import com.proyecto.springboot.app.models.entity.Categoria;
import com.proyecto.springboot.app.models.entity.Usuario;

public interface ICategoriaDaoImpl {

	List<Categoria> findAllCat();
	
	public void save(Categoria categoria);
	
	public Usuario findOne(Long idcategoria);
	
	public void delete(Long idcategoria);

}
