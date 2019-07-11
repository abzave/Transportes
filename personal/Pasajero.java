/**
 * Declaracion de la clase Pasajero, maneja la informacion de los pasajeros en el sistema.
 * 
 * @author Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas.
 * 
 * @version 21/09/18
 */

package personal;

public class Pasajero extends Persona {
	
  private static int cantidadPasajeros;
  private int id;
  private String correo;
  
  /**
   * Constructor de la clase Pasajero, se utilizará cuando se requiera crear un objeto 
   * de tipo Pasajero dentro del programa.
   * 
   * Pasajero pasajero= new Pasajero(pNombre, pCedula, pTelefono);
   * 
   * @param String pNombre
   * @param String pCedula
   * @param String pTelefono
   */
  
  public Pasajero(String pNombre, String pCedula, String pTelefono, String correo) {
    super(pNombre, pCedula,pTelefono);
    cantidadPasajeros++;
    id = cantidadPasajeros;
    this.correo = correo;
  }
  public Pasajero(String pNombre, String pCedula, String pTelefono, String correo, int pID) {
    super(pNombre, pCedula,pTelefono);
    cantidadPasajeros++;
    id = pID;
    this.correo = correo;
  }
  /**
   * Metodos accesores de la clase Pasajero. 
   */
  public int getId() {
    return id;
  }
  
  public String getCorreo() {
    return correo;
  }
}