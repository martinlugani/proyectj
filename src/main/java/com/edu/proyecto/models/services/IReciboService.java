package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.proyecto.models.entity.Recibo;

public interface IReciboService {

	public void saveAll(List<Recibo> lista);
	
	public List<Recibo> findAllRec();

	public Page<Recibo> findAllRec(Pageable pageable);

	



}
