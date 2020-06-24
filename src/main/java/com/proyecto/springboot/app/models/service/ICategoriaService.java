package com.proyecto.springboot.app.models.service;

import java.util.List;

import com.proyecto.springboot.app.models.entity.Categoria;

public interface ICategoriaService {

	public List<Categoria> findAllCat();

	public void save(Categoria categoria);
	
	public Categoria findOneCat(Long idcategoria);
	
	public void delete(Long idcategoria);
}
