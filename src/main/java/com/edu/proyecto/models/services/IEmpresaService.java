package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.proyecto.models.entity.Empresa;

public interface IEmpresaService {
	
	
	public List<Empresa> findAll();

	public Page<Empresa> findAll(Pageable pageable);

	public Empresa findOne(Long idempresa);


}
