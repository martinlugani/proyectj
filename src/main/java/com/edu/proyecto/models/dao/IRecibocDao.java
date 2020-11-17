package com.edu.proyecto.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.edu.proyecto.models.entity.ReciboC;
import com.edu.proyecto.models.entity.Usuario;

public interface IRecibocDao extends PagingAndSortingRepository <ReciboC, Long> {

	public List<ReciboC> findByUsuario(Usuario usuario);
}
