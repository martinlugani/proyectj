package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.proyecto.models.entity.Categoria;
import com.edu.proyecto.models.entity.TipoDocumento;

public interface ITipoDocumentoService {
	
	public List<TipoDocumento> findAll();

	public void save(TipoDocumento tipodocumento);
	
	public TipoDocumento findOne(Long idtipodocumento);
	
	public void delete(Long idtipodocumento);
	
	public Page<TipoDocumento> findAll(Pageable pageable);





}
