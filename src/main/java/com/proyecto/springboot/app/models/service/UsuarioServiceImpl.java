package com.proyecto.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.springboot.app.models.dao.IUsuarioDao;
import com.proyecto.springboot.app.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioDao.findAll();
	}

	@Override
	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long idusuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findOne(idusuario);
	}

	@Override
	@Transactional
	public void delete(Long idusuario) {
		usuarioDao.delete(idusuario);
		
	}

}
