package com.edu.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
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

import com.edu.proyecto.models.entity.Categoria;
import com.edu.proyecto.models.entity.Recibo;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;

@Controller

public class ReciboController{

	private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\Casa\\Desktop\\Workspace\\proyecto\\uploads\\RecibosImpotados.csv";
	//@Autowired
	//private ICategoriaService categoriaService;
	

	private Recibo recibo;
	
	
	
	@GetMapping("/feedCustomerData")
	public void setDataInDB() throws IOException {
		   try (
		            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
		        ) {
		            CsvToBean<Recibo> csvToBean = new CsvToBeanBuilder(reader)
		                    .withType(Recibo.class)
		                    .withIgnoreLeadingWhiteSpace(true)
		                    .build();

		            Iterator<Recibo> reciboIterator = csvToBean.iterator();

		            while (reciboIterator.hasNext()) {
		            	Recibo recibo = reciboIterator.next();
		            	//Recibo recibo = new Recibo();
		                System.out.println("idrecibo : " + recibo.getIdrecibo());
		                System.out.println("concepto : " + recibo.getConcepto());
		                System.out.println("tipo : " + recibo.getTipoconcepto());
		                System.out.println("importe : " + recibo.getImporte());
		                System.out.println("importe total : " + recibo.getImportetotal());

		                System.out.println("==========================");
		            }
		        }
		    }
	
		
	/*@SuppressWarnings("unchecked")
	List<Recibo> beans = new CsvToBeanBuilder(new FileReader("C:\\Users\\jvillca\\Desktop\\Jimena\\Workspace\\proyecto\\uploads\\RecibosImpotados.csv"))
	    	       .withType(Recibo.class).build().parse();*/
	//Map<String, String> values = new CSVReaderHeaderAware(new FileReader("C:\\Users\\jvillca\\Desktop\\Jimena\\Workspace\\proyecto\\uploads\\RecibosImpotados.csv")).readMap();
	}
		

