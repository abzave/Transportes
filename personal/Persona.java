/**
 * Maneja los datos importantes de una persona. Todas las clases que tengan que ver con Personal 
 * dentro del sistema heredan de esta clase.
 * 
 * @author Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas.
 * 
 * @version 21/09/18
 */

package personal;

public abstract class Persona {
  protected String nombre;
  protected String cedula;
  protected String telefono;
  
  /**
   * Constructor 1 de la clase Persona utilizado en la clase Usuario cada vez que se crea uno nuevo en el sistema
   * 
   * Persona persona= new Persona(pNombre, pCedula);
   * 
   * @param String pNombre
   * @param String pCedula
   */
  
  public Persona(String pNombre, String pCedula) {
    setNombre(pNombre);
    setCedula(pCedula);
  }
  
  /**
   * Constructor 2 de la clase Persona utilizado en las clases Pasajero y Chofer
   *  cada vez que se crea uno nuevo en el sistema.
   * 
   * Persona persona= new Persona(pNombre, pCedula, pTelefono);
   * 
   * @param String pNombre
   * @param String pCedula
   * @param String pTelefono
   */
  
  public Persona(String pNombre, String pCedula, String pTelefono) {
    setNombre(pNombre);
    setCedula(pCedula);
    setTelefono(pTelefono);
  }

  /**
   * Metodos Accesores de la clase Persona 
   */
  
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String pNombre) {
    nombre = pNombre;
  }

  public String getCedula() {
    return cedula;
  }
  
  private void setCedula(String pCedula) {
    cedula = pCedula;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String pTelefono) {
    telefono = pTelefono;
  }
  @Override
  public String toString() {
    String msg;
    msg = "Nombre: " + nombre + "\n";
    msg += "Cedula: " + cedula + "\n";
    msg += "telefono: " + telefono + "\n";
    return msg;
  }
  
  public String tabString() {
  	String msg;
    msg = "Nombre: " + nombre + "   ";
    msg += "Cedula: " + cedula + "   ";
    msg += "telefono: " + telefono + "   ";
    return msg;
  }
  
}