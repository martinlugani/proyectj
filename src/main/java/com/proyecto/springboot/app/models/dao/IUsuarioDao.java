package com.proyecto.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.proyecto.springboot.app.models.entity.Usuario;

public interface IUsuarioDao extends PagingAndSortingRepository<Usuario, Long>{

	

}
