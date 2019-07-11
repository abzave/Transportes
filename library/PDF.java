package library;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDF {

	private final PDDocument documento = new PDDocument();
	private final PDPage pagina = new PDPage();
	private final PDFont letra = PDType1Font.TIMES_ROMAN;
	private final int tamanio = 14;
	private String nombre;
	
	public PDF(String nombre) {
	  setNombre(nombre);
  	 
	}
	
	public void setNombre(String nombre) {
	  this.nombre = nombre;
	}
	
	public String getNombre() {
	  return nombre;
	}
	
	public void crear(String contenido) throws IOException {
	  documento.addPage(pagina);
    final PDPageContentStream datos = new PDPageContentStream(documento, pagina);
    datos.beginText();
    datos.setFont(letra, tamanio);
    datos.newLineAtOffset(150, 750);
    String[] lineas = separarLineas(contenido);
    for(int i = 0; i < lineas.length; i++) {
      datos.showText(lineas[i]);
      datos.newLineAtOffset(0, -15f);
    }
    datos.endText();
    datos.close();
    documento.save(nombre);
	}
	
	private String[] separarLineas(String contenido) {
	  String[] retorno = contenido.split("\n");
	  return retorno;
	}

}
