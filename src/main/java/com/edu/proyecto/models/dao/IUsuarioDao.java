package com.edu.proyecto.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.edu.proyecto.models.entity.Usuario;

public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

	

}
