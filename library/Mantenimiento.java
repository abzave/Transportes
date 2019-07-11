package library;

/**
 * Maneja los mantenimientos realizados.
 * @author Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas.
 * @version 21/09/18.
 */

public class Mantenimiento {
  private String fechaInicio;
  private double monto;
  private String detalle;
  private String tipo;
  private Empresa empresa;
  
  /**
   * Constructor de la clase Mantenimiento, se utilizará cada vez que se requiera crear y almacenar un objeto
   * de esta clase, el cual será almacenado en la lista de mantenimientos de los vehiculos.
   * 
   * Mantenimiento mantenimiento= new Mantenimiento(pFehaInicio, pMonto, pDetalle, pTipo, pEmpresa);
   * vehiculo.getMantenimientos().add(mantenimiento);
   * 
   * @param String pFechaInicio
   * @param double pMonto
   * @param String pDetalle
   * @param String pTipo
   * @param Empresa pEmpresa
   */
  
  public Mantenimiento(String pFechaInicio, double pMonto, String pDetalle, String pTipo, Empresa pEmpresa) {
  	fechaInicio = pFechaInicio;
  	monto = pMonto;
  	detalle = pDetalle;
  	tipo = pTipo;
  	empresa = pEmpresa;
  }
  
  /**
   * Metodos accesores de la clase Matenimiento.
   */
  
  public String getFechaInicio() {
    return fechaInicio;
  }
  public double getMonto() {
    return monto;
  }
  public String getDetalle() {
    return detalle;
  }
  public String getTipo() {
    return tipo;
  }
  public Empresa getEmpresa() {
    return empresa;
  }

  @Override
	public String toString() {
  	return "Mantenimiento:\nFechaInicio: " + fechaInicio + "\nMonto: " + monto + "\nDetalle: " + detalle
			+ "\nTipo: " + tipo + "\nEmpresa: " + empresa ;
  }  

}
