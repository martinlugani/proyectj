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
import com.proyecto.springboot.app.models.entity.Usuario;
import com.proyecto.springboot.app.models.service.IUsuarioService;

@Controller
@SessionAttributes("usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Value("${application.controllers.mensaje}")
	private String mensaje;
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("mensaje", mensaje);
		return "inicio";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = new PageRequest(page, 4);

		Page<Usuario> usuarios = usuarioService.findAll(pageRequest);
		
		PageRender<Usuario> pageRender = new PageRender<Usuario>("/listar", usuarios);
		
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());
		model.addAttribute("page", pageRender);
		return "listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo", "Formulario de usuario");
		return "form";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id,RedirectAttributes flash, Map<String, Object> model) {
		
		Usuario usuario = null;
		
		if(id > 0) {
			usuario = usuarioService.findOne(id);
			if(usuario == null) {
				flash.addFlashAttribute("error","El id de usuario no puede ser cero!");
				return "redirect:/listar";
			}
		} else {
			flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
			return "redirect:/listar";
		}
		model.put("usuario", usuario);
		model.put("titulo", "Editar usuario");
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de usuario");
			return "form";
			
		}
		String mensajeflash = (usuario.getIdusuario() != null) ? "Usuario editado con exito!" : "Usuario creado con exito!";

		usuarioService.save(usuario);
		status.setComplete();
		flash.addFlashAttribute("success",mensajeflash);
		return "redirect:listar";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id,RedirectAttributes flash) {
		
		if(id > 0) {
			usuarioService.delete(id);
		}
		flash.addFlashAttribute("success","Usuario eliminado con exito!");
		return "redirect:/listar";
	}
}
