package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {

  private String contenido = "";
  private String nombreArchivo;
  
  public Archivo(String nombreArchivo) {
    setNombreArchivo(nombreArchivo);
  }
  
  public String leer() throws IOException {
	String contenidoTemp;
  	FileReader archivo = new FileReader(nombreArchivo);
  	BufferedReader bufferedReader = new BufferedReader(archivo);
  	while((contenidoTemp = bufferedReader.readLine()) != null) {
      contenido += contenidoTemp;
  	}
  	bufferedReader.close();
  	return contenido;
  }
  
  public void escribir(String aEscribir) throws IOException {
	PrintWriter archivo = new PrintWriter(nombreArchivo);
	archivo.write(aEscribir);
	archivo.close();
  }

  public String getContenido() {
    return contenido;
  }

  public void setContenido(String contenido) {
    this.contenido = contenido;
  }

  public String getNombreArchivo() {
    return nombreArchivo;
  }

  public void setNombreArchivo(String nombreArchivo) {
    this.nombreArchivo = nombreArchivo;
  }

}
