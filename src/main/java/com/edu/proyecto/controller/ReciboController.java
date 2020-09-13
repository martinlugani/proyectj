package com.edu.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.proyecto.models.entity.Archivo;
import com.edu.proyecto.models.entity.Categoria;
import com.edu.proyecto.models.entity.Recibo;
import com.edu.proyecto.models.entity.Usuario;
import com.edu.proyecto.models.services.IArchivoService;
import com.edu.proyecto.models.services.IReciboService;
import com.edu.proyecto.util.paginator.PageRender;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

@Controller

public class ReciboController {

	public static String archno;

	//private static final String SAMPLE_CSV_FILE_PATH = "uploads\\"+archno;

	@Autowired
	private IReciboService recservice;
	
	@Autowired
	private IArchivoService archivoservice;

	@GetMapping(value = "/insertaregistros/{nombre}")
	public String insertar(@PathVariable(value = "nombre") String nombre, Map<String, Object> model, RedirectAttributes flash) throws IOException {
		System.out.print(nombre);
		//Archivo archivo = archivoservice.findOneArch(id);
		archno=nombre;
		System.out.print(archno);
		String  SAMPLE_CSV_FILE_PATH = "uploads\\"+ archno;
		File file = new File(SAMPLE_CSV_FILE_PATH);
		String path = file.getAbsolutePath();
		try (Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		) {
			CsvToBean<Recibo> csvToBean = new CsvToBeanBuilder(reader).withType(Recibo.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			List<Recibo> lista = new ArrayList<Recibo>();
			Iterator<Recibo> reciboIterator = csvToBean.iterator();

			while (reciboIterator.hasNext()) {
				Recibo recibo = reciboIterator.next();
				/* System.out.println("idrecibo : " + recibo.getIdrecibo());
				 * System.out.println("concepto : " + recibo.getConcepto()); */
				lista.add(recibo);
				System.out.println("==========================");
			}
			for (Recibo recibo : lista) {
				System.out.println(recibo);
			}
			recservice.saveAll(lista);
			return "redirect:/listararchivos";
			}
		
	}
	@RequestMapping(value = "/listarecibos", method = RequestMethod.GET)
	public String listarecibos(@RequestParam(name="page", defaultValue="0") int page,Model model) {
		Pageable pageRequest = PageRequest.of(page, 4);

		Page<Recibo> recibo = recservice.findAllRec(pageRequest);
		
		PageRender<Recibo> pageRender = new PageRender<Recibo>("/listarecibos", recibo);
				
		model.addAttribute("titulo", "Listado de recibo");
		model.addAttribute("recibo", recservice.findAllRec());
		model.addAttribute("page", pageRender);
		return "listarecibos";
		
	}	
}

