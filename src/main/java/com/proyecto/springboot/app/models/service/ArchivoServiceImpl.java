package com.proyecto.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.springboot.app.models.dao.IArchivoDao;
import com.proyecto.springboot.app.models.dao.IUsuarioDao;
import com.proyecto.springboot.app.models.entity.Archivo;

@Service

public class ArchivoServiceImpl implements IArchivoService{
	@Autowired
	private IArchivoDao archivoDao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Archivo> findAllArch() {
		// TODO Auto-generated method stub
		return (List<Archivo>)archivoDao.findAll();
	 //return (List<Usuario>)usuarioDao.findAll();
	}
	
	
	@Transactional
	public void save(Archivo archivo) {
		archivoDao.save(archivo);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Archivo findOneArch(Long idarchivo) {
		// TODO Auto-generated method stub
		return archivoDao.findOne(idarchivo);
	}
	
	//prepersis
	@Override
	@Transactional
	public void delete(Long idarchivo) {
		// TODO Auto-generated method stub
		archivoDao.delete(idarchivo);
	}
	
	@Override
	public Page<Archivo> findAllArch(Pageable pageable) {
		// TODO Auto-generated method stub
		return archivoDao.findAll(pageable);
	}
}
