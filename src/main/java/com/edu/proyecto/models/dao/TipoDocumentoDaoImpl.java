	package com.edu.proyecto.models.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.edu.proyecto.models.entity.TipoDocumento;

@Repository
public class TipoDocumentoDaoImpl implements ITipoDocumentoDao{
	
	@PersistenceContext
	private EntityManager ep;

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoDocumento> findAllTipoDoc() {
		// TODO Auto-generated method stub
		return ep.createQuery("from tipodocumento").getResultList();
	}

	@Override
	public TipoDocumento findOneTipoDoc(Long idtipodocumento) {
		return ep.find(TipoDocumento.class, idtipodocumento);
	}
	
	@Override
	public void save(TipoDocumento tipodocumento) {
		if(tipodocumento.getIdtipodocumento() != null && tipodocumento.getIdtipodocumento() >0) {
			ep.merge(tipodocumento);
		} else {
			ep.persist(tipodocumento);
		}
	}

	@Override
	public void delete(Long idtipodocumento) {
		ep.remove(findOneTipoDoc(idtipodocumento));
	}

}

