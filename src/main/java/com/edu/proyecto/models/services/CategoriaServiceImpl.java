package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.proyecto.models.dao.ICategoriaDao;
import com.edu.proyecto.models.entity.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDao categoriaDao;
	

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
		return categoriaDao.findById(idcategoria).orElse(null);
	}
	
	//prepersis
	@Override
	@Transactional
	public void delete(Long idcategoria) {
		// TODO Auto-generated method stub
		categoriaDao.deleteById(idcategoria);
	}
	
	@Override
	public Page<Categoria> findAllCat(Pageable pageable) {
		// TODO Auto-generated method stub
		return categoriaDao.findAll(pageable);
	}
}
