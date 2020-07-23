package com.proyecto.springboot.app.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.proyecto.springboot.app.models.entity.Archivo;

import com.proyecto.springboot.app.models.service.IArchivoService;

public interface IArchivoDao extends PagingAndSortingRepository<Archivo, Long>{

}
