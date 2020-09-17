package com.edu.proyecto.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.edu.proyecto.models.entity.TipoDocumento;

public interface ITipoDocumentoDao extends PagingAndSortingRepository<TipoDocumento, Long>{

/*	TipoDocumento findOneTipoDoc(Long idtipodocumento);

	void save(TipoDocumento tipodocumento);

	void delete(Long idtipodocumento);

	List<TipoDocumento> findAllTipoDoc(); 

	List<TipoDocumento> findAllTipoDoc();
	
	public void save(TipoDocumento tipodocumento);
	
	public TipoDocumento findOneTipoDoc(Long idtipodocumento);
	
	public void delete(Long idtipodocumento);

	public Page<TipoDocumento> findAll(Pageable pageable);*/


}
