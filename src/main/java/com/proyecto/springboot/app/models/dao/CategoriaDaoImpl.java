package com.proyecto.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.proyecto.springboot.app.models.entity.Categoria;
import com.proyecto.springboot.app.models.entity.Usuario;

@Repository
public class CategoriaDaoImpl implements ICategoriaDaoImpl{


	@PersistenceContext
	private EntityManager ep;

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findAllCat() {
		// TODO Auto-generated method stub
		return ep.createQuery("from Categoria").getResultList();
	}

	@Override
	public void save(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario findOne(Long idcategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long idcategoria) {
		// TODO Auto-generated method stub
		
	}

}
