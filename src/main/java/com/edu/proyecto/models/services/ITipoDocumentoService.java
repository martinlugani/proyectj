package com.edu.proyecto.models.services;

import java.util.List;

import com.edu.proyecto.models.entity.TipoDocumento;

public interface ITipoDocumentoService {
	
	public List<TipoDocumento> findAllTipoDoc();

	public void save(TipoDocumento tipodocumento);
	
	public TipoDocumento findOneTipoDoc(Long idtipodocumento);
	
	public void delete(Long idtipodocumento);


}
