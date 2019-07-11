package library;

import java.util.ArrayList;

/**
 * Declaracion de la clase Vehiculo. Almacena informcación sobre el vehiculo.
 * @author Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas.
 * @version 21/09/18
 */
public class Vehiculo {
  private String placa;
  private String annoFabricacion;
  private String color;
  private String marca;
  private String vin;
  private String sede;
  //Estado puede ser, en servicio, en matenimiento, fuera de servicio.
  private String estado;
  private int capacidad;
  private int kilometraje;
  private ArrayList<Mantenimiento> mantenimientos;
  /**
   * Constructor de la clase Vehiculo, se utilizará cada vez que sea necesario crear un objeto de tipo Vehiculo.
   * 
   * Vehiculo vehiculo= new Vehiculo(pPlaca, pAnnoFabricacion, pColor, pMarca, pVin, pSede, pCapacidad, pKilometraje,
   * pMantenimientos);
   * 
   * @param String pPlaca
   * @param String pAnnoFabricacion
   * @param String pColor
   * @param String pMarca
   * @param String pVin
   * @param String pSede
   * @param int pCapacidad
   * @param int pKilometraje
   * @param ArrayList<Mantenimiento> pMantenimientos
   */
  public Vehiculo(String pPlaca, String pAnnoFabricacion, String pColor, String pMarca, String pVin, String pSede,
			int pCapacidad, int pKilometraje, ArrayList<Mantenimiento>pMantenimientos) {
  	setEstadoServicio();
  	mantenimientos = pMantenimientos;
		placa = pPlaca;
		annoFabricacion = pAnnoFabricacion;
		color = pColor;
		marca = pMarca;
		vin = pVin;
		sede = pSede;
		capacidad = pCapacidad;
		kilometraje = pKilometraje;
	}
  
  /**
   * Metodos accesores de la clase Vehiculo.
   */
  
	public String getPlaca() {
  	return placa;
  }

  public String getAnnoFabricacion() {
  	return annoFabricacion;
  }

  public String getColor() {
  	return color;
  }

  public String getMarca() {
  	return marca;
  }

  public String getVin() {
  	return vin;
  }

  public String getSede() {
  	return sede;
  }

  public String getEstado() {
  	return estado;
  }

  public int getCapacidad() {
  	return capacidad;
  }

  public int getKilometraje() {
  	return kilometraje;
  }

  public ArrayList<Mantenimiento> getMantenimientos() {
  	return mantenimientos;
  }

  public void setEstadoServicio() {
  	estado = "En servicio";
  }
  
  public void setEstadoMantenimiento() {
  	estado = "En mantenimiento";
  }
  
  public void setEstadoFueraServicio() {
  	estado = "Fuera de servicio";
  }

@Override
	public String toString() {
  	return "Vehiculo: \nPlaca: " + placa + "\nAñoFabricacion: " + annoFabricacion + "\nColor: " + color + "\nMarca: " + marca
  			+ "\nVin: " + vin + "\nSede: " + sede + "\nEstado: " + estado + "\nCapacidad: " + capacidad + "\nKilometraje: "
  			+ kilometraje + "\nMantenimientos: " + mantenimientos;
  }  

}