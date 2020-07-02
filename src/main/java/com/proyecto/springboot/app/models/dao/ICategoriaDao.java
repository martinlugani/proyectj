package com.proyecto.springboot.app.models.dao;

import java.util.List;

import com.proyecto.springboot.app.models.entity.Categoria;

public interface ICategoriaDao {

	List<Categoria> findAllCat();
	
	public void save(Categoria categoria);
	
	public Categoria findOneCat(Long idcategoria);
	
	public void delete(Long idcategoria);

}
