package com.edu.proyecto.controller;

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

import com.edu.proyecto.models.entity.Firma;
import com.edu.proyecto.models.entity.Usuario;
import com.edu.proyecto.models.services.IFirmaService;
import com.edu.proyecto.models.services.IUsuarioService;
import com.edu.proyecto.util.paginator.PageRender;

@Controller
//@SessionAttributes("usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IFirmaService firmaService;
	
	@Value("${application.controllers.mensaje}")
	private String mensaje;
	
	private String molestia;
	
	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("mensaje", mensaje);
		return "inicio";
	}
	@GetMapping("/generarecibos")
	public String generarecibos(Model model) {
		model.addAttribute("molestia", mensaje);
		return "generarecibos";
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue="0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Usuario> usuarios = usuarioService.findAll(pageRequest);
		
		PageRender<Usuario> pageRender = new PageRender<Usuario>("/listar", usuarios);
		
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarioService.findAll());
		model.addAttribute("page", pageRender);
		return "listar";
	}
	
	public static Long idusuario;
	
	@GetMapping(value = "/verusuario/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		//Usuario usuario = new Usuario();
		
		Usuario usuario = usuarioService.findOne(id);
		idusuario=id;
		System.out.print(idusuario);
		if (usuario == null) {
			flash.addFlashAttribute("error", "El usuario no existe en la base de datos");
			return "listar";
		}
		model.put("usuario", usuario);
		model.put("titulo", "Detalle usuario: " + usuario.getNombre());
		return "verusuario";
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
	
	/*--------------------------------------------------------------------*/
	/*--------------------------------------------------------------------*/


//Hacer que el formulario funcione comun, setear la firma en VER{ID} y pasarlo en el formulario en un firma.setidusuario;
	
	
	@RequestMapping(value = "/formfirma")
	public String crearfirma(Map<String, Object> model) {
		System.out.print(idusuario);
		Firma firma = new Firma();
		firma.setIdusuario(idusuario);

		model.put("firma", firma);
		model.put("titulo", "Formulario de firma");
		return "formfirma";
		
	}
	/* System.out.println("idrecibo : " + recibo.getIdrecibo());
	 * System.out.println("concepto : " + recibo.getConcepto()); */
	
	@RequestMapping(value = "/formfirma", method = RequestMethod.POST)
	public String guardar(@Valid Firma firma, BindingResult result, Model model,RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de firma");
			firma.setIdusuario(idusuario); //aca se guarda realmente
			System.out.print(idusuario);

			return "listar";
		}
		firma.setIdusuario(idusuario);
		System.out.print(idusuario);
		
		String mensajeFlash = (firma.getIdfirma() != null)? "firma editado con éxito!" : "Firma creado con éxito!";
		firmaService.save(firma);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	
}

/*@RequestMapping(value="/formfirma/{idusuario}")
public String editar(@PathVariable(value="idusuario") Long idusuario,RedirectAttributes flash, Map<String, Object> model) {
	Usuario usuario = null;
	
	if(idusuario > 0) {
		usuario = usuarioService.findOne(idusuario);
		if(usuario == null) {
			flash.addFlashAttribute("error","El id de usuario no puede ser cero!");
			return "redirect:/listar";
		}
	} else {
		flash.addFlashAttribute("error", "El ID del cliente no puede ser cero!");
		return "redirect:/listar";
	}
	model.put("firma", firma);
	model.put("titulo", "Editar firma");
	return "formfirma";
}*/