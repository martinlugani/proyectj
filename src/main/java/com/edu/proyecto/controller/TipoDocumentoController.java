package com.edu.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.edu.proyecto.models.services.ITipoDocumentoService;


@Controller
@SessionAttributes("tipodocumento")

public class TipoDocumentoController {
	
	@Autowired
	private ITipoDocumentoService tipodocumentoService;
	
	
	@RequestMapping(value = "/listatipodoc", method = RequestMethod.GET)
	public String listatipodoc(Model model) {
		model.addAttribute("titulo", "Listado de tipo documento");
		model.addAttribute("tipodocumento", tipodocumentoService.findAllTipoDoc());
		return "listatipodoc";
	}


}
