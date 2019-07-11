/**
 * Clase Chofer, maneja toda la informacion relativa a los choferes dentro del sistema.
 * 
 * @author Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas.
 * 
 * @version 21/09/18
 */

package personal;

import java.util.ArrayList;
import library.Licencia;

public class Chofer extends Persona implements Comparable{
  private String correo;
  private int cantViajes;
  private ArrayList<Licencia> licencias;
  
  /**
   * Constructor 1 de la clase Chofer, será utilizado cada vez que se requiera
   * crear o registrar un nuevo chofer en el sitema.
   * 
   * Chofer chofer = new Chofer(pNombre, pCedula, pTelefono, pCorreo, pLicencias);
   * 
   * @param String pNombre
   * @param String pCedula
   * @param String pCorreo
   * @param String pTelefono
   * @param ArrayList<Licencia> pLicenias
   */
  
  public Chofer(String pNombre, String pCedula, String pTelefono, String pCorreo, ArrayList<Licencia> pLicencias) {
    super(pNombre, pCedula, pTelefono);
    correo = pCorreo;
    licencias = pLicencias;
  }
  
  /**
   * Constructor 2 de la clase Chofer, será utilizado cada vez que se requiera
   * crear o registrar un nuevo chofer en el sitema.
   * 
   * Chofer chofer = new Chofer(pNombre, pCedula, pTelefono, pCorreo, pLicencias, pCantViajes);
   * 
   * @param String pNombre
   * @param String pCedula
   * @param String pTelefono
   * @param String pCorreo
   * @param ArrayList<Licencia> pLicenias
   * @param int pCantViajes
   */
  
  public Chofer(String pNombre, String pCedula, String pTelefono, String pCorreo, ArrayList<Licencia> pLicencias, int pCantViajes) {
    super(pNombre, pCedula, pTelefono);
    correo = pCorreo;
    licencias = pLicencias;
    cantViajes = pCantViajes;
  }

  /**
   * Metodo para añadir una licencia a la lista de licencias pertenecientes al chofer.
   * 
   * Licencia licencia= new Licencia();
   * chofer.add(licencia);
   * 
   * @param Licencia pLicencia
   * 
   * @return Agrega una licencia a la lista de licencias.
   */
  
  public void annadirLicencia(Licencia pLicencia) {
  	licencias.add(pLicencia);
  }
  
  /**
   * Metodos accesores de la clase Chofer 
   */
  
  public ArrayList<Licencia> getLicencias() {
    return licencias;
  }
  
  public int getCantViajes() {
		return cantViajes;
	}
  
  public void aumentarViajes() {
  	cantViajes++;
  }
  
	public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }
  
  @Override
  public String toString() {
  	String msg;
    msg = "Nombre: " + nombre + " \n";
    msg += "Cedula: " + cedula + " \n";
    msg += "Telefono: " + telefono +" \n";
    msg += "Correo: " + correo + "\n";
    msg += "Cantidad de viajes: "+ cantViajes +"\n";
    msg += "Licencias: " + licencias + "\n";
    return msg;
  }
  
 public int compareTo(Object o) {
    try {
    	Chofer chofer = (Chofer)o;
    	return chofer.getCantViajes() - cantViajes;
    }catch(Exception e) {
    	return 0;
    }
 }

}