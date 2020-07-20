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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.springboot.app.models.entity.Categoria;
import com.proyecto.springboot.app.models.service.ICategoriaService;


@Controller
@SessionAttributes("categoria")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
//	private IUsuarioService usuarioService;
	
	@RequestMapping(value = "/listarcategoria", method = RequestMethod.GET)
	public String listarcategoria(Model model) {
		model.addAttribute("titulo", "Listado de categoria");
		model.addAttribute("categoria", categoriaService.findAllCat());
		return "listarcategoria";
	}

	@RequestMapping(value = "/formcategoria")
	public String crear(Map<String, Object> model) {

		Categoria categoria = new Categoria();
		model.put("categoria", categoria);
		model.put("titulo", "Formulario de categoria");
		return "formcategoria";
	}
	
	@RequestMapping(value="/formcategoria/{idcategoria}")
	public String editar(@PathVariable(value="idcategoria") Long idcategoria,RedirectAttributes flash, Map<String, Object> model) {
		
		Categoria categoria = null;
		
		if(idcategoria > 0) {
			categoria = categoriaService.findOneCat(idcategoria);
		if(categoria == null) {
				flash.addFlashAttribute("error","El id de categoria no existe en BBDD!");
				return "redirect:/listar";
				}
		} else {
			return "redirect:/listarcategoria";
		}
		model.put("categoria", categoria);
		model.put("titulo", "Editar categoria");
		return "formcategoria";
	}

	@RequestMapping(value = "/formcategoria", method = RequestMethod.POST)
	public String guardar(@Valid Categoria categoria, BindingResult result, Model model,RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de categoria");
			return "formcategoria";
		}
		String mensajeFlash = (categoria.getIdcategoria() != null)? "Categoria editado con éxito!" : "Categoria creado con éxito!";
		categoriaService.save(categoria);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listarcategoria";
	}
	
	@RequestMapping(value="/eliminarcategoria/{idcategoria}")
	public String eliminar(@PathVariable(value="idcategoria") Long idcategoria,RedirectAttributes flash) {
		
		if(idcategoria > 0) {
			categoriaService.delete(idcategoria);
			flash.addFlashAttribute("success", "Categoria eliminado con éxito!");
		}
		return "redirect:/listarcategoria";
	}
}
