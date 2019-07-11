/**
 * Clase Secretaria, clase encargada de la funcionalidad de la secretaria
 * dentro del programa.
 * 
 * @author : Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas.
 * @version : 21/09/2018
 */

package personal;

import java.util.ArrayList;

import aplicacion.AplTransportes;
import library.Viaje;
import util.ObjectToJsonParser;

public class Secretaria extends Usuario {
	
	private AplTransportes aplicacion;
	private ObjectToJsonParser par = new ObjectToJsonParser();
	/**
	 *  Constructor para los objetos de tipo de la clase Secretaria, 
	 *  cada vez que se requierase creara un objeto a traves de este constructor.
	 *  
	 *  Secretaria secretaria1= new Secretaria(pNombre, pCedula, pTelefono, pDepartamento, pNombreUsuario, pContrasenna);
	 *  
	 *  @param String pNombre
	 *  @param String pCedula
	 *  @param Sring pTelefono
	 *  @param String pDepartamento
	 *  @param String pNomreUsuario
	 *  @param String pContrasenna
	 *  
	 */
	public Secretaria(String pNombre, String pCedula, String pTelefono, String pDepartamento, String pNombreUsuario, String pContrasenna) {
		super(pNombre, pCedula, pTelefono, pDepartamento, pNombreUsuario, pContrasenna);
	}
	/**
	 * Metodo de registro de pasajeros, este metodo agregara un nuevo pasajero 
	 * a la lista perteneciente a la clase Secretaria.
	 * Secretaria.registrarPasajero(pasajero1);
	 * 
	 * @param Pasajero pPasajero;
	 * @return boolean dependiendo si el pasajero fue registrado con exito, true o false.
	 */
	public boolean registrarPasajero(Pasajero pPasajero) {
		for(Pasajero actual : aplicacion.getPasajeros()) {
			if(actual.getCedula().equals(pPasajero.getCedula())) {
				return false;
			}
		}
		aplicacion.getPasajeros().add(pPasajero);
		par.save("pasajerosDB.json", par.parsePasajero(pPasajero).toJSONString());
		return true;
	}
	
	public void annadirViaje(Viaje pViaje) {
	  aplicacion.getViajes().add(pViaje);
	  par.save("viajes.json", par.parseViaje(pViaje).toJSONString());
	}
	/**
	 * Metodos accesores de la clase Secretaria.
	 */

	public ArrayList<Pasajero> getPasajeros() {
		return aplicacion.getPasajeros();
	}

	public ArrayList<Viaje> getViajes() {
		return aplicacion.getViajes();
	}


	public void setAplicacion(AplTransportes pAplicacion) {
		aplicacion = pAplicacion;
	}
	
	public AplTransportes getAplicacion() {
	  return aplicacion;
	}
	
}