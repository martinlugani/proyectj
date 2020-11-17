package com.edu.proyecto.models.services;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.proyecto.models.entity.Firma;
import com.edu.proyecto.models.entity.Usuario;

public interface IFirmaService {
	
	public List<Firma> findAllFirma();
	
	public Page<Firma> findAllFirma(Pageable pageable);

	public void save(Firma firma);
	
	public Firma findOneFirma(Long idfirma);
	
	public Firma findByUsuario(Usuario usuario);
	
	public void delete(Long idusuario);
}
