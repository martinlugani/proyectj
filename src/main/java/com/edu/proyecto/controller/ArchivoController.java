package com.edu.proyecto.controller;

import java.util.Map;
import java.util.UUID;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.proyecto.models.entity.Archivo;
import com.edu.proyecto.models.services.IArchivoService;
import com.edu.proyecto.util.paginator.PageRender;

@Controller
@SessionAttributes("archivo")
public class ArchivoController {

	@Autowired
	private IArchivoService archivoService;
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(value = "/formarchivo")
	public String crear(Map<String, Object> model) {

		Archivo archivo = new Archivo();
		model.put("archivo", archivo);
		model.put("titulo", "Importar archivo");
		return "formarchivo";
	}

	@RequestMapping(value = "/formarchivo", method = RequestMethod.POST)
	public String guardar(@Valid Archivo archivo, BindingResult result, Model model,
			@RequestParam("file") MultipartFile archivito, RedirectAttributes flash, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de archivo");
			return "formarchivo";
		}

		if (!archivito.isEmpty()) {
			String uniqueFilename = UUID.randomUUID().toString() + "_" + archivito.getOriginalFilename();
			Path rootPath = Paths.get("uploads").resolve(uniqueFilename);
			Path rootAbsoloutPath = rootPath.toAbsolutePath();
			
			log.info("rootPath: " + rootPath);
			log.info("rootPath: " + rootAbsoloutPath);
			
			try {
				Files.copy(archivito.getInputStream(), rootAbsoloutPath);
				flash.addFlashAttribute("info", "Has subido correctamente'" + uniqueFilename + "'");
				archivo.setNombre(uniqueFilename);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String mensajeFlash = (archivo.getIdarchivo() < 0) ? "Archivo editado con éxito!" : "Archivo creado con éxito!";
		archivoService.save(archivo);
		status.setComplete();
		flash.addFlashAttribute("success", mensajeFlash);
		return "redirect:listararchivos";
	}
	
	@GetMapping(value = "/ver/{idarchivo}")
	public String ver(@PathVariable(value = "idarchivo") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Archivo archivo = archivoService.findOneArch(id);
		if (archivo == null) {
			flash.addFlashAttribute("error", "El archivo no existe en la base de datos");
			return "redirect:/listararchivos";
		}

		model.put("archivo", archivo);
		model.put("titulo", "Detalle archivo: " + archivo.getNombre());
		return "ver";
	}

	
	@RequestMapping(value = "/listararchivos", method = RequestMethod.GET)
	public String listarcategoria(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Archivo> archivo = archivoService.findAllArch(pageRequest);

		PageRender<Archivo> pageRender = new PageRender<Archivo>("/listararchivos", archivo);

		model.addAttribute("titulo", "Listado de categoria");
		model.addAttribute("archivo", archivoService.findAllArch());
		model.addAttribute("page", pageRender);
		return "listararchivos";
	}

	@RequestMapping(value="/eliminararchivo/{idarchivo}")
	public String eliminar(@PathVariable(value="idarchivo") Long idarchivo,RedirectAttributes flash) {
		
		if(idarchivo > 0) {
			Archivo archivoser = archivoService.findOneArch(idarchivo);
			
			archivoService.delete(idarchivo);
			flash.addFlashAttribute("success", "Archivo eliminado con éxito!");
			Path rootPath = Paths.get("uploads").resolve(archivoser.getNombre()).toAbsolutePath();
			File archivo = rootPath.toFile();

			
			if(archivo.exists() && archivo.canRead()) {
				if(archivo.delete()) {
					flash.addFlashAttribute("info", "Foto " + archivoser.getNombre() + " eliminada con exito!");
				}
			}

		}
		return "redirect:/listararchivos";
	}
}
