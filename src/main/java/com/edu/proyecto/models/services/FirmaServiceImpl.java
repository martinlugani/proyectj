package com.edu.proyecto.models.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.proyecto.models.dao.IFirmaDao;
import com.edu.proyecto.models.entity.Firma;



@Service
public class FirmaServiceImpl implements IFirmaService{

	@Autowired
	private IFirmaDao firmaDao;
//	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Firma> findAllFirma() {
		// TODO Auto-generated method stub
		return (List<Firma>) firmaDao.findAll();
		// return (List<Usuario>)usuarioDao.findAll();
	}

	@Transactional
	public void save(Firma firma) {
		firmaDao.save(firma);

	}
	
	@Transactional(readOnly = true)
	public Firma findOneFirma(Long idFirma) {
		// TODO Auto-generated method stub
		return firmaDao.findById(idFirma).orElse(null);
	}
	
	
	/*@Override
	@Transactional(readOnly = true)
	public Usuario findOne(Long idusuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(idusuario).orElse(null);
	}*/

	@Override
	@Transactional
	public void delete(Long idfirma) {
		// TODO Auto-generated method stub
		firmaDao.deleteById(idfirma);
	}

	@Override
	public Page<Firma> findAllFirma(Pageable pageable) {
		// TODO Auto-generated method stub
		return firmaDao.findAll(pageable);
	}
}
