package com.edu.proyecto.models.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.edu.proyecto.models.entity.Usuario;

public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

	public Usuario findByUsername(String name);

	public Usuario findByEmail (String correo);
//	public Page<Usuario> findByUsername(Pageable pageable);
	


}
