package com.proyecto.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.springboot.app.models.dao.ICategoriaDaoImpl;
import com.proyecto.springboot.app.models.entity.Categoria;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaDaoImpl categoriaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findAllCat() {
		// TODO Auto-generated method stub
		return categoriaDao.findAllCat();
	}

	@Override
	public void save(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria findOneCat(Long idcategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long idcategoria) {
		// TODO Auto-generated method stub
		
	}

}
