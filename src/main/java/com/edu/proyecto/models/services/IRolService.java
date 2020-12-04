package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.proyecto.models.entity.ReciboC;
import com.edu.proyecto.models.entity.Rol;
import com.edu.proyecto.models.entity.Usuario;

public interface IRolService {
	public List<Rol> findAllRol();

	public void save(Rol rol);
	
	public Rol findOne(Long idrol);
	
	public void delete(Long idrol);

	public Rol Rol(Long idrol);
	

	

}
