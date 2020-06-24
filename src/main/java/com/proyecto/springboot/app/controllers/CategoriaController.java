package com.proyecto.springboot.app.controllers;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.proyecto.springboot.app.models.entity.Categoria;
import com.proyecto.springboot.app.models.service.ICategoriaService;


@Controller
@SessionAttributes("categoria")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService categoriaService;

	@RequestMapping(value = "/listarcategoria", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de categoria");
		model.addAttribute("categoria", categoriaService.findAllCat());
		return "listarcategoria";
	}
	@RequestMapping(value="/formcategoria/idcategoria}")
	public String editar(@PathVariable(value="idcategoria") Long idcategoria, Map<String, Object> model) {
		
		Categoria categoria = null;
		
		if(idcategoria > 0) {
			categoria = categoriaService.findOneCat(idcategoria);
		} else {
			return "redirect:/listarcategoria";
		}
		model.put("categoria", categoria);
		model.put("titulo", "Editar categoria");
		return "formcategoria";
	}

	@RequestMapping(value = "/formcategoria", method = RequestMethod.POST)
	public String guardar(@Valid Categoria categoria, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de categoria");
			return "formcategoria";
		}

		categoriaService.save(categoria);
		status.setComplete();
		return "redirect:listarcategoria";
	}
	
	@RequestMapping(value="/eliminarcategoria/{idcategoria}")
	public String eliminar(@PathVariable(value="idcategoria") Long idcategoria) {
		
		if(idcategoria > 0) {
			categoriaService.delete(idcategoria);
		}
		return "redirect:/listarcategoria";
	}
}



