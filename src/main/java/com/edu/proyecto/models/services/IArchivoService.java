package com.edu.proyecto.models.services;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.proyecto.models.entity.Archivo;

public interface IArchivoService {
	
	public List<Archivo> findAllArch();

	public Page<Archivo> findAllArch(Pageable pageable);
	
	public void save(Archivo archivo);
	
	public Archivo findOneArch(Long idarchivo);
	
	public void delete(Long idarchivo);


}
