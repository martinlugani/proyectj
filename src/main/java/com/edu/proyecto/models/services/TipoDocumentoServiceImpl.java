package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.proyecto.models.dao.ITipoDocumentoDao;
import com.edu.proyecto.models.entity.TipoDocumento;
import com.edu.proyecto.models.entity.Usuario;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {
	@Autowired
	private ITipoDocumentoDao tipodocumentoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoDocumento>)tipodocumentoDao.findAll();
	}

	@Override
	@Transactional
	public void save(TipoDocumento usuario) {
		tipodocumentoDao.save(usuario);
		
	}

	@Override
	@Transactional(readOnly = true)
	public TipoDocumento findOne(Long idusuario) {
		// TODO Auto-generated method stub
		return tipodocumentoDao.findById(idusuario).orElse(null);
	}
	
	

	@Override
	@Transactional
	public void delete(Long idusuario) {
		tipodocumentoDao.deleteById(idusuario);
		
	}
	@Override
	public Page<TipoDocumento> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return tipodocumentoDao.findAll(pageable);
	}

	


}


