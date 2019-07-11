package library;

/**
 * Maneja la información de las empresas.
 * @author Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas.
 * @version 21/09/18.
 */

public class Empresa {
  private String razonSocial;
  private String cedulaJuridica;
  private String telefono;
  private Direccion direccion;
  /**
   * Constructor de la clase Empresa, se utilizara cada vez que sea necesario 
   * crear un objeto de tipo empresa dentro del programa
   * 
   * Empresa empresa= new Empresa(pRazonSocial, pCedulaJuridica, pTelefono, pDireccion);
   * 
   * @param String pRazonSocial
   * @param String pCedulaJuridica
   * @param String pTelefono
   * @param Direccion pDireccion
   * 
   */
  
  public Empresa(String pRazonSocial, String pCedulaJuridica, String pTelefono, Direccion pDireccion) {
	razonSocial = pRazonSocial;
	cedulaJuridica = pCedulaJuridica;
	telefono = pTelefono;
	direccion = pDireccion;
  }

  /**
   * Metodos accesores de la clase Empresa.
   */
  public String getRazonSocial() {
	return razonSocial;
  }

  public String getCedulaJuridica() {
	return cedulaJuridica;
  }

  public String getTelefono() {
	return telefono;
  }

  public Direccion getDireccion() {
	return direccion;
  }

@Override
  public String toString() {
	return "\nRazonSocial: " + razonSocial + "\nCedulaJuridica: " + cedulaJuridica + "\nTelefono: " + telefono
			+ "\nDireccion: " + direccion;
  }
  
}
