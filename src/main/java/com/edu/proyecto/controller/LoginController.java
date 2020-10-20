package com.edu.proyecto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.proyecto.models.entity.Categoria;
import com.edu.proyecto.models.entity.Usuario;
import com.edu.proyecto.models.services.IUsuarioService;

@Controller
@SessionAttributes("usuario")
public class LoginController {

	
	@Autowired
	private IUsuarioService usuarioService;
	
	
	@RequestMapping(value="/nuevapass/{idusuario}")
	public String editar(@PathVariable(value="idusuario") Long idusuario,RedirectAttributes flash, Map<String, Object> model) {
		
		Usuario usuario = null;
		
		if(idusuario > 0) {
			usuario = usuarioService.findOne(idusuario);
		if(usuario == null) {
				flash.addFlashAttribute("error","El id de usuario no existe en BBDD!");
				return "redirect:/listar";
				}
		} else {
			return "redirect:/listar";
		}
		model.put("usuario", usuario);
		model.put("usuario", usuario.setContrasena(contrasena));
		model.put("titulo", "Editar contraseña");
		return "nuevapass";
	}
}
