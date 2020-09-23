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
		tabla.setSpacingAfter(50);
		
		tabla.addCell("Datos de usuario");
		tabla.addCell("Nombre  " + reciboc.getUsuario().getNombre());
		tabla.addCell("Apellido "+reciboc.getUsuario().getApellido());
		tabla.addCell("Nro Documento  "+reciboc.getUsuario().getNrodocumento());
		tabla.addCell("Correo electronico  "+ reciboc.getUsuario().getEmail());

		PdfPTable tabla2 = new PdfPTable(1);
		tabla.setSpacingAfter(50);
		
		tabla.addCell("Datos de recibo");
		tabla.addCell("Nro recibo " + reciboc.getId());
		
		document.add(tabla);
		document.add(tabla2);

	}

}
