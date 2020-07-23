package com.proyecto.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.springboot.app.util.paginator.PageRender;
import com.proyecto.springboot.app.models.entity.Archivo;
import com.proyecto.springboot.app.models.service.IArchivoService;
//import com.proyecto.springboot.app.models.service.IUsuarioService;

@Controller
@SessionAttributes("archivo")
public class ArchivoController {

	@Autowired
	private IArchivoService archivoService;

	@RequestMapping(value = "/listararchivos", method = RequestMethod.GET)
	public String listarcategoria(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = new PageRequest(page, 4);

		Page<Archivo> archivo = archivoService.findAllArch(pageRequest);

		PageRender<Archivo> pageRender = new PageRender<Archivo>("/listararchivos", archivo);

		model.addAttribute("titulo", "Listado de categoria");
		model.addAttribute("archivo", archivoService.findAllArch());
		model.addAttribute("page", pageRender);
		return "listararchivos";
	}
	
	
	
	@RequestMapping(value = "/formarchivo")
	public String crear(Map<String, Object> model) {

		Archivo archivo = new Archivo();
		model.put("archivo", archivo);
		model.put("titulo", "Importar archivo");
		return "formarchivo";
	}
	
	@RequestMapping(value = "/formarchivo", method = RequestMethod.POST)
	public String guardar(@Valid Archivo archivo, BindingResult result, Model model,RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de archivo");
			return "formarchivo";
		}
		String mensajeFlash = (archivo.getIdarchivo() != null)? "Archivo editado con éxito!" : "Archivo creado con éxito!";
		archivoService.save(archivo);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listararchivos";
	}
}
