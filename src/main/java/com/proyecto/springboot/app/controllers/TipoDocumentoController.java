package com.proyecto.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.proyecto.springboot.app.models.entity.TipoDocumento;
import com.proyecto.springboot.app.models.service.ITipoDocumentoService;


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
