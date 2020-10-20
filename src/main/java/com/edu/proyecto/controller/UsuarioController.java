package com.edu.proyecto.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import com.edu.proyecto.models.entity.TipoDocumento;
import com.edu.proyecto.models.entity.Usuario;
import com.edu.proyecto.models.services.IFirmaService;
import com.edu.proyecto.models.services.ITipoDocumentoService;
import com.edu.proyecto.models.services.IUsuarioService;
import com.edu.proyecto.util.paginator.PageRender;

@Controller
//@SessionAttributes("usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IFirmaService firmaService;
	
	@Autowired
	private ITipoDocumentoService tipodocumentoservice;
	
	
	
	
	
	
	@Value("${application.controllers.mensaje}")
	private String mensaje;
	
//	private String molestia;
	
	
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
	
	public  Long idusuariomail;
	public  String mailnuevo;
	public  String passnuevo;
	public String usuarionuevo;

	@RequestMapping(value = "/form")
	public String crear( Model model) {

		Usuario usuario = new Usuario();
		List<TipoDocumento> findAll = tipodocumentoservice.findAll();
		
		
		model.addAttribute("titulo", "Formulario de usuario");
		model.addAttribute("usuario", usuario);
		model.addAttribute("tipodocumento", findAll);
//		System.out.print("NUEVO USUARIO "+usuario.getIdusuario());
//		idusuariomail = usuario.getIdusuario() ;
//		mailnuevo = usuario.getEmail();
//		passnuevo = usuario.getContrasena();
		
//		enviarmailpass();

		return "form";
	}
	
	@RequestMapping(value="/form/{idusuario}")
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
		model.put("usuario", usuario);
		model.put("titulo", "Editar usuario");
		
		return "form";
	}
	
	public static Long maxUsuario;
	


	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		

		List<TipoDocumento> findAll = tipodocumentoservice.findAll();

		if (result.hasErrors()) {
			model.addAttribute("tipodocumento", findAll);
			model.addAttribute("titulo", "Formulario de usuario");
			return "form";	
		}		
			String uniqueFilename = UUID.randomUUID().toString();
						
			flash.addFlashAttribute("info", "Has generado la contraseña '" + uniqueFilename);
			usuario.setContrasena(uniqueFilename);
			
			usuario.getIdusuario();
			
		String mensajeflash = (usuario.getIdusuario() != null) ? "Usuario editado con exito!" : "Usuario creado con exito!";

		usuarioService.save(usuario);
		status.setComplete();
		flash.addFlashAttribute("success",mensajeflash);

		System.out.print("NUEVO USUARIO "+usuario.getIdusuario());
		idusuariomail = usuario.getIdusuario() ;
		mailnuevo = usuario.getEmail();
		passnuevo = usuario.getContrasena();
		usuarionuevo = usuario.getNick();
		
		enviarmailpass();
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
		firma.setUsuarioid(idusuario);

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
			firma.setUsuarioid(idusuario); //aca se guarda realmente
			System.out.print(idusuario);

			return "listar";
		}
		firma.setUsuarioid(idusuario);
		System.out.print(idusuario);
		
		String mensajeFlash = (firma.getUsuarioid() != null)? "firma editado con éxito!" : "Firma creado con éxito!";
		firmaService.save(firma);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listar";
	}
	
	public String enviarmailpass() {
		
	Usuario usuario = new Usuario();
	
	List<Usuario> findAllUse = usuarioService.findAll();

		System.out.println( "Hello World!" );
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        
        
//      mailnuevo = usuario.getEmail();
//		passnuevo = usuario.getContrasena();
        Session sesion = Session.getDefaultInstance(propiedad);
        
        String correoEnvia = "hedlanrecibos@gmail.com";//tu correo gmaildesde donde se envia 
        String contrasena = "lanabanana";//tu contraseña de acceso a gmaila esa cuenta
        
        String receptor = mailnuevo; //cuenta que recibe
        
        String asunto = "Bienvenido al sistema de RECIBOS HEDLAN";
        String mensaje= new String ("Estimado usuario   "+usuarionuevo
        		+ " Se acaba de dar de alta su usuario en el sistema 	"
        		+ "					sus credenciales son:		"
        		+ "USUARIO	 " + usuarionuevo
        		+ "CONTRASEÑA "+ passnuevo
        		+ "su contraseña es temporal, ingrese al siguiente link para cambiar su password "
        		+ "http://localhost:8080/nuevapass/"+idusuariomail   ) 		;

        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            
            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
            
           
            
            
        } catch (AddressException ex) {
            Logger.getLogger(ex.toString());
            System.err.println(ex);
        } catch (MessagingException ex) {
            Logger.getLogger(ex.toString());
            System.err.println(ex);
        }
        
        
        Logger.getLogger("Enviado");
        
        
//        try {
//			EmailClient.sendAsHtml("tincholan10@gmail.com",
//			        "Martin te manda esto",
//			        "<h2>Java Mail Example</h2><p>hi there!</p>");
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    
    
		return "listar";
		
	}
	
	
}
