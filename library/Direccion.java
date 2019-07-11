package library;

/**
 * Maneja la información de las direcciones de los viajes.
 * @author Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas.
 * @version 21/09/18.
 */

public class Direccion {
  private String provincia;
  private String canton;
  private String distrito;
  private String sennas;
  /**
   * Constructor de la clase Direccion, 
   * se utilizara cada vez que se requiera crear un objeto de tipo Direccion
   * 
   * Direccion direccion= new Direccion(pProvincia, pCanton, pDistrito, pSennas);
   * 
   * @param String pProvincia
   * @param String pCanton
   * @param String pDistrito
   * @param String pSennas
   * 
   */
  public Direccion(String pProvincia, String pCanton, String pDistrito, String pSennas) {
  	provincia = pProvincia;
  	canton = pCanton;
  	distrito = pDistrito;
  	sennas = pSennas;
  }

  /**
   * Metodos accesores de la clase Direccion.
   */
  public String getProvincia() {
  	return provincia;
  }

  public String getCanton() {
  	return canton;
  }

  public String getDistrito() {
  	return distrito;
  }

  public String getSennas() {
  	return sennas;
  }

@Override
  public String toString() {
		return "Provincia: " + provincia + "\nCantón: " + canton + "\nDistrito: " + distrito + "\nSeñas: " + sennas;
  }

  public String tabString() {
  	return "Provincia: " + provincia + "  Cantón: " + canton + "  Distrito: " + distrito + "  Señas: " + sennas;
  }

}