package com.edu.proyecto.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.edu.proyecto.models.entity.ReciboC;

public interface IRecibocDao extends PagingAndSortingRepository <ReciboC, Long> {

}
