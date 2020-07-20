package com.proyecto.springboot.app.models.service;

import java.util.List;

import com.proyecto.springboot.app.models.entity.TipoDocumento;

public interface ITipoDocumentoService {
	
	public List<TipoDocumento> findAllTipoDoc();

	public void save(TipoDocumento tipodocumento);
	
	public TipoDocumento findOneTipoDoc(Long idtipodocumento);
	
	public void delete(Long idtipodocumento);


}
