package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.edu.proyecto.models.dao.IEmpresaDao;
import com.edu.proyecto.models.dao.IFirmaDao;
import com.edu.proyecto.models.entity.Empresa;

public class EmpresaServiceImpl implements IEmpresaService{
	@Autowired
	private IEmpresaDao empresaDao;
//	private IUsuarioDao usuarioDao;
	
	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		// TODO Auto-generated method stub
		return (List<Empresa>)empresaDao.findAll();
	}


	@Override
	@Transactional(readOnly = true)
	public Empresa findOne(Long idempresa) {
		// TODO Auto-generated method stub
		return empresaDao.findById(idempresa).orElse(null);
	}

	
	@Override
	public Page<Empresa> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return empresaDao.findAll(pageable);
	}






}
