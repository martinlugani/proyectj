package com.edu.proyecto.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.proyecto.models.entity.ReciboC;
import com.edu.proyecto.models.entity.Usuario;


public interface IReciboCService {

	public void saveAll(List<ReciboC> lista);
	
	public List<ReciboC> findAllRec();
	
	public List<ReciboC> findAllById(Long idusuario);

	public Page<ReciboC> findAllRec(Pageable pageable);

	public ReciboC findOne(Long id);
	
	
	public List<ReciboC> findByIdUsuario(Usuario usuario);

	public void save(ReciboC reciboC2);

}
