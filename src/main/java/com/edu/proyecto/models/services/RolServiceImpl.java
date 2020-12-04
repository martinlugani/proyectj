package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.proyecto.models.dao.IRolDao;
import com.edu.proyecto.models.dao.ITipoDocumentoDao;
import com.edu.proyecto.models.entity.ReciboC;
import com.edu.proyecto.models.entity.Rol;
import com.edu.proyecto.models.entity.TipoDocumento;
import com.edu.proyecto.models.entity.Usuario;

@Service
public class RolServiceImpl implements IRolService{

	@Autowired
	private IRolDao rolDao;
	
	@Transactional(readOnly = true)
	public List<Rol> findAllRol() {
		// TODO Auto-generated method stub
		return (List<Rol>)rolDao.findAll();
	}
	
	
	@Override
	@Transactional
	public void save(Rol usuario) {
		// TODO Auto-generated method stub
		rolDao.save(usuario);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public Rol findOne(Long idusuario) {
		// TODO Auto-generated method stub
		return rolDao.findById(idusuario).orElse(null);
	}
	


	@Override
	public void delete(Long idusuario) {
		// TODO Auto-generated method stub
		rolDao.deleteById(idusuario);
	}


	@Override
	public com.edu.proyecto.models.entity.Rol Rol(Long idrol) {
		// TODO Auto-generated method stub
		return null;
	}


	



	
}
