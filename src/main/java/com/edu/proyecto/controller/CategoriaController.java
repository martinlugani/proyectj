package com.edu.proyecto.controller;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.proyecto.models.entity.Categoria;
import com.edu.proyecto.models.services.ICategoriaService;
import com.edu.proyecto.util.paginator.PageRender;


@Controller
@SessionAttributes("categoria")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService categoriaService;
	
//	private IUsuarioService usuarioService;
	
	@RequestMapping(value = "/listarcategoria", method = RequestMethod.GET)
	public String listarcategoria(@RequestParam(name="page", defaultValue="0") int page,Model model) {
		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Categoria> categoria = categoriaService.findAllCat(pageRequest);
		
		PageRender<Categoria> pageRender = new PageRender<Categoria>("/listarcategoria", categoria);
				
		model.addAttribute("titulo", "Listado de categoria");
		model.addAttribute("categoria", categoriaService.findAllCat());
		model.addAttribute("page", pageRender);
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
