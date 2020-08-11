package com.edu.proyecto.models.dao;

import java.util.List;

import com.edu.proyecto.models.entity.TipoDocumento;

public interface ITipoDocumentoDao {


/*	TipoDocumento findOneTipoDoc(Long idtipodocumento);

	void save(TipoDocumento tipodocumento);

	void delete(Long idtipodocumento);

	List<TipoDocumento> findAllTipoDoc(); */

	List<TipoDocumento> findAllTipoDoc();
	
	public void save(TipoDocumento tipodocumento);
	
	public TipoDocumento findOneTipoDoc(Long idtipodocumento);
	
	public void delete(Long idtipodocumento);

}
