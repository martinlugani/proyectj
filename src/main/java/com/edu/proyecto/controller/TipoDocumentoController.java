package com.edu.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.edu.proyecto.models.entity.TipoDocumento;
import com.edu.proyecto.models.services.ITipoDocumentoService;
import com.edu.proyecto.util.paginator.PageRender;


@Controller
@SessionAttributes("tipodocumento")

public class TipoDocumentoController {
	
	@Autowired
	private ITipoDocumentoService tipodocumentoService;
	
	
/*	@RequestMapping(value = "/listatipodoc", method = RequestMethod.GET)
	public String listatipodoc(Model model) {
		model.addAttribute("titulo", "Listado de tipo documento");
		model.addAttribute("tipodocumento", tipodocumentoService.findAll());
		return "listatipodoc";
	}*/
	@RequestMapping(value = "/listatipodoc", method = RequestMethod.GET)
	public String listatipodoc(@RequestParam(name="page", defaultValue="0") int page,Model model) {
		Pageable pageRequest = PageRequest.of(page, 4);

		Page<TipoDocumento> tipodocumento = tipodocumentoService.findAll(pageRequest);
		
		PageRender<TipoDocumento> pageRender = new PageRender<TipoDocumento>("/listatipodoc", tipodocumento);
				
		model.addAttribute("titulo", "Listado de documentos");
		model.addAttribute("tipodocumento", tipodocumentoService.findAll());
		model.addAttribute("page", pageRender);
		return "listatipodoc";
		
	}


}
