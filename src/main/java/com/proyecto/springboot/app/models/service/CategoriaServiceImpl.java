package com.proyecto.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.springboot.app.models.dao.ICategoriaDao;
import com.proyecto.springboot.app.models.entity.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDao categoriaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAllCat() {
		// TODO Auto-generated method stub
		return (List<Categoria>)categoriaDao.findAll();
	 //return (List<Usuario>)usuarioDao.findAll();
	}
	
	
	@Transactional
	@Override
	public void save(Categoria categoria) {
		categoriaDao.save(categoria);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria findOneCat(Long idcategoria) {
		// TODO Auto-generated method stub
		return categoriaDao.findOne(idcategoria);
	}
	
	//prepersis
	@Override
	@Transactional
	public void delete(Long idcategoria) {
		// TODO Auto-generated method stub
		categoriaDao.delete(idcategoria);
	}
	
	@Override
	public Page<Categoria> findAllCat(Pageable pageable) {
		// TODO Auto-generated method stub
		return categoriaDao.findAll(pageable);
	}
}
