package com.edu.proyecto.models.view.pdf;

import java.awt.Color;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.edu.proyecto.models.entity.ReciboC;

@Component("verecibo")
public class ReciboPdfView extends AbstractPdfView {
	
	

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		ReciboC reciboc = (ReciboC) model.get("reciboc");
		
		PdfPTable tabla = new PdfPTable(1);
		
		tabla.addCell("Datos de Empresa");
		tabla.addCell(" " + reciboc.empresa.getEmpresa());
		tabla.addCell(" " + reciboc.empresa.getCuit());
		tabla.addCell(" " + reciboc.empresa.getDireccion());
		tabla.addCell(" " + reciboc.empresa.getFechainicioactividades());



		PdfPTable tabla4 = new PdfPTable(1);
		tabla4.setSpacingAfter(20);
		
		tabla4.addCell("Datos de usuario");
		tabla4.addCell("Nombre  " + reciboc.getUsuario().getNombre());
		tabla4.addCell("Apellido "+reciboc.getUsuario().getApellido());
	//tabla.addCell("Nro Documento  "+reciboc.getUsuario().getNrodocumento());
	//	tabla.addCell("Email  "+ reciboc.getUsuario().getEmail());
	//	tabla.addCell("Fecha de ingresa  "+ reciboc.getUsuario().getFechaAlta());
	//	tabla.addCell("Categoria :  Empleado de planta");
	//	tabla.addCell("Tipo de contrato:  Completo ");

		
		PdfPTable tabla2 = new PdfPTable(1);
		tabla2.setSpacingAfter(20);
		
		PdfPCell cell = null;

		tabla2.addCell("Datos de recibo");
		tabla2.addCell("Nro recibo " + reciboc.getId());
		
		document.add(tabla);
		document.add(tabla2);
		tabla2.setSpacingAfter(20);
		
		PdfPTable tabla3 = new PdfPTable(2);
		tabla3.addCell("Concepto: ");
		tabla3.addCell("Precio: ");

		tabla3.addCell(reciboc.getConceptotres());
		tabla3.addCell(reciboc.getImportetres().toString());
		tabla3.addCell(reciboc.getConceptodos());
		
		tabla3.addCell(reciboc.getImportedos().toString());
		tabla3.addCell(reciboc.getConceptouno());
		tabla3.addCell(reciboc.getImporteuno().toString());

		

	    cell = new PdfPCell(new Phrase("Total: "+ reciboc.getImportetotal()));
	    cell.setColspan(3);

	    cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
	    tabla3.addCell(cell);
	    tabla3.addCell(reciboc.getImportetotal().toString());
	    
	    document.add(tabla3);
		

	}

}