package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.proyecto.models.dao.IRecibocDao;
import com.edu.proyecto.models.entity.ReciboC;
import com.edu.proyecto.models.entity.Usuario;

@Service
public class ReciboCServiceImpl implements IReciboCService {

	@Autowired
	private IRecibocDao reciboDao;
	
	
	@Transactional
	public void saveAll(List<ReciboC> reciboc) {
		// TODO Auto-generated method stub
		reciboDao.saveAll(reciboc);

	}
	
	@Transactional
	public void save(ReciboC reciboc) {
		reciboDao.save(reciboc);
		
	}
	@Override
	@Transactional(readOnly = true)
	public ReciboC findOne(Long id) {
		// TODO Auto-generated method stub
		return reciboDao.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<ReciboC> findAllRec() {
		// TODO Auto-generated method stub
		return (List<ReciboC>)reciboDao.findAll();
	 //return (List<Usuario>)usuarioDao.findAll();
	}
	
	@Override
	public Page<ReciboC> findAllRec(Pageable pageable) {
		// TODO Auto-generated method stub
		return reciboDao.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public List<ReciboC> findAllRecUse(Long idusuario) {
		
		// TODO Auto-generated method stub
		return (List<ReciboC>)reciboDao.findAll();
	 //return (List<Usuario>)usuarioDao.findAll();
	}



	@Override
	public List<ReciboC> findAllById(Long idusuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReciboC> findByIdUsuario(Usuario  usuario) {
		// TODO Auto-generated method stub
		return reciboDao.findByUsuario(usuario);
	}

	
	
	
	

}
