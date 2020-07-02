package com.proyecto.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.proyecto.springboot.app.models.entity.Categoria;
import com.proyecto.springboot.app.models.dao.ICategoriaDao;

@Repository
public class CategoriaDaoImpl implements ICategoriaDao{


	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> findAllCat() {
		// TODO Auto-generated method stub
		return em.createQuery("from Categoria").getResultList();
	}

	@Override
	public Categoria findOneCat(Long idcategoria) {
		return em.find(Categoria.class, idcategoria);
	}
	
	@Override
	public void save(Categoria categoria) {
		if(categoria.getIdcategoria() != null && categoria.getIdcategoria() >0) {
			em.merge(categoria);
		} else {
			em.persist(categoria);
		}
	}


	@Override
	public void delete(Long idcategoria) {
		em.remove(findOneCat(idcategoria));
	}

}
