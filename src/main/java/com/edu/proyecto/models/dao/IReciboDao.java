package com.edu.proyecto.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.edu.proyecto.models.entity.Categoria;
import com.edu.proyecto.models.entity.Recibo;
import com.edu.proyecto.models.entity.TipoDocumento;


public interface IReciboDao extends PagingAndSortingRepository <Recibo, Long>  {

//public interface ICategoriaDao extends PagingAndSortingRepository<Categoria, Long>{

	
}
