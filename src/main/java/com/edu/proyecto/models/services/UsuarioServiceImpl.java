package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.proyecto.models.dao.IUsuarioDao;
import com.edu.proyecto.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>)usuarioDao.findAll();
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
		return usuarioDao.findById(idusuario).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long idusuario) {
		usuarioDao.deleteById(idusuario);
		
	}
	@Override
	public Page<Usuario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return usuarioDao.findAll(pageable);
	}

}
