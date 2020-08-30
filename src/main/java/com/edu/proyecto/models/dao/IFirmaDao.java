package com.edu.proyecto.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.edu.proyecto.models.entity.Firma;

public interface IFirmaDao  extends PagingAndSortingRepository<Firma, Long>{

}
