package com.proyecto.springboot.app.models.dao;

import java.util.List;

import com.proyecto.springboot.app.models.entity.Categoria;
import com.proyecto.springboot.app.models.entity.TipoDocumento;
import com.proyecto.springboot.app.models.entity.Usuario;

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
