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

import com.edu.proyecto.models.entity.Categoria;
import com.edu.proyecto.models.entity.Firma;
import com.edu.proyecto.models.entity.Usuario;
import com.edu.proyecto.models.services.IFirmaService;
import com.edu.proyecto.models.services.IUsuarioService;
import com.edu.proyecto.util.paginator.PageRender;

@Controller
@SessionAttributes("firma")
public class FirmaController {
	
	@Autowired
	private IFirmaService firmaService;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@RequestMapping(value = "/listarfirma", method = RequestMethod.GET)
	public String listarfirma(@RequestParam(name="page", defaultValue="0") int page,Model model) {
		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Firma> firma = firmaService.findAllFirma(pageRequest);
		
		PageRender<Firma> pageRender = new PageRender<Firma>("/listarfirma", firma);
				
		model.addAttribute("titulo", "Listado de firma");
		model.addAttribute("firma", firmaService.findAllFirma());
		model.addAttribute("page", pageRender);
		return "listar";
		
	}

	
	@RequestMapping(value="/eliminarfirma/{idfirma}")
	public String eliminar(@PathVariable(value="idfirma") Long idfirma,RedirectAttributes flash) {
		
		if(idfirma > 0) {
			firmaService.delete(idfirma);
			flash.addFlashAttribute("success", "Firma eliminado con éxito!");
		}
		return "redirect:/listar";
	}
	
}
