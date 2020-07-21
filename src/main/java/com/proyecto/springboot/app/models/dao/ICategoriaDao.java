package com.proyecto.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.proyecto.springboot.app.models.entity.Categoria;
import com.proyecto.springboot.app.models.service.ICategoriaService;

public interface ICategoriaDao extends PagingAndSortingRepository<Categoria, Long>{








}

