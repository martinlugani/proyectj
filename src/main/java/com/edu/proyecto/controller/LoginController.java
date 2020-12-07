package com.edu.proyecto.controller;

import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.proyecto.models.entity.Rol;
import com.edu.proyecto.models.entity.Usuario;
import com.edu.proyecto.models.services.IUsuarioService;

@Controller
@SessionAttributes("usuario")
public class LoginController {

	
	@Autowired
	private IUsuarioService usuarioService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping ("/login")
	public String login(@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required = false) String logout,
			Model model, Principal principal, RedirectAttributes flash,Authentication auten,HttpServletRequest request) {
		
		if(principal != null) {
			flash.addFlashAttribute("info", "Ya ha inciado sesión anteriormente");
			
//				Usuario usuario = usuarioService.findByUsername(auten.getName());
//				log.info(auten.getName() + " ID - ID usuario " + usuario.getIdusuario());

			}
				
//		}
		log.info("Se salto el principal");
		if(error != null) {
			model.addAttribute("error", "Error en el login: Nombre de usuario o contraseña incorrecta, por favor vuelva a intentarlo!");
	//		System.out.println("USUARIO "+principal);
	//		System.out.println("ROL"+ auten.getAuthorities());
	//		System.out.println("ROL"+ request.isUserInRole);
		}
		
		if(logout != null) {
			model.addAttribute("success", "Ha cerrado sesión con éxito!");
		}
				
		return "login";
	}
	
	//Public void validaractivo();
	
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@RequestMapping(value="/nuevacontrasena")
	public String nuevacontrasena(@PathVariable(value="passuno") String passuno,@PathVariable(value="passdos") String passdos,RedirectAttributes flash, Map<String, Object> model,Authentication auten,AuthenticationManagerBuilder builder) {
		Usuario usuario = usuarioService.findByUsername(auten.getName());
		log.info(auten.getName() + " ID - ID usuario " + usuario.getIdusuario());
		
		if(passuno != passdos) {
			model.put("error", "Error los valores en los campos no coiciden");

		}
		else {
			String passencriptada = passEncoder.encode(passuno);
			System.out.println("LA NUEVA CONTRASENA ENCRIPTADA ES "+passencriptada);
			usuario.setPassword(passencriptada);
			usuarioService.save(usuario);
		}
		return "redirect:/";

	}
	
}
