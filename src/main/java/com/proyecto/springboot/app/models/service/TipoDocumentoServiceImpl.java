package com.proyecto.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.springboot.app.models.dao.ITipoDocumentoDao;
import com.proyecto.springboot.app.models.entity.TipoDocumento;

@Service
public class TipoDocumentoServiceImpl implements ITipoDocumentoService {
	@Autowired
	private ITipoDocumentoDao tipodocumentoDao;
	
	@Transactional(readOnly = true)
	public List<TipoDocumento> findAllTipoDoc() {
		// TODO Auto-generated method stub
		return tipodocumentoDao.findAllTipoDoc();
	}


	@Override
	@Transactional(readOnly = true)
	public TipoDocumento findOneTipoDoc(Long idtipodocumento) {
		// TODO Auto-generated method stub
		return tipodocumentoDao.findOneTipoDoc(idtipodocumento);
	}
	
	@Override
	public void save(TipoDocumento tipodocumento) {
		// TODO Auto-generated method stub
		tipodocumentoDao.save(tipodocumento);		
	}

	@Override
	public void delete(Long idtipodocumento) {
		// TODO Auto-generated method stub
		tipodocumentoDao.delete(idtipodocumento);

		
	}


}


