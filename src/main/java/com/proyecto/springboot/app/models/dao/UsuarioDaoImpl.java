package com.proyecto.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.proyecto.springboot.app.models.entity.Usuario;

@Repository
public class UsuarioDaoImpl implements IUsuarioDao {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Usuario").getResultList();
	}

	@Override
	public Usuario findOne(Long idusuario) {
		return em.find(Usuario.class, idusuario);
	}
	
	@Override
	public void save(Usuario usuario) {
		if(usuario.getIdusuario() != null && usuario.getIdusuario() >0) {
			em.merge(usuario);
		} else {
			em.persist(usuario);
		}
	}


	@Override
	public void delete(Long idusuario) {
		em.remove(findOne(idusuario));
	}

}
