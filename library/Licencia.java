package library;
/**
 * Clase Licencia, maneja la informacion de la licencia que tiene cada chofer registrado en el sistema
 * 
 * @author Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas.
 * @version 21/09/18.
 */
public class Licencia {

	private static int licencias;
  private int numeroLicencia;
  private String tipo;
  private String fechaEmision;
  private String fechaExpiracion;
  
  /**
   * Constructor de la clase Licencia se utilizará cada vez que se cree un objeto de tipo Licencia
   * 
   * Licencia licencia= new Licencia(tipo, fechaEmision, fechaExpiracion, numeroLicencia);
   * 
   * @param String tipo
   * @param String fechaEmision
   * @param String fechaExpiracion
   * @param int numeroLicencia
   */
  
  public Licencia(String tipo, String fechaEmision, String fechaExpiracion, int numeroLicencia) {
  	licencias++;
    setTipo(tipo);
    setFechaEmision(fechaEmision);
    setFechaExpiracion(fechaExpiracion);
    setNumeroLicencia(numeroLicencia);
  }
  
  /**
   * Constructor de la clase Licencia se utilizará cada vez que se cree un objeto de tipo Licencia
   * 
   * Licencia licencia= new Licencia(tipo, fechaEmision, fechaExpiracion);
   * 
   * @param String tipo
   * @param String fechaEmision
   * @param String fechaExpiracion
   */
  public Licencia(String tipo, String fechaEmision, String fechaExpiracion) {
  	licencias++;
    setTipo(tipo);
    setFechaEmision(fechaEmision);
    setFechaExpiracion(fechaExpiracion);
    setNumeroLicencia(licencias);
  }

  
  /**
   * Metodos accesores de la clase Licencia
   */
  
  public int getNumeroLicencia() {
    return numeroLicencia;
  }

  private void setNumeroLicencia(int numeroLicencia) {
    this.numeroLicencia = numeroLicencia;
  }

  public String getTipo() {
    return tipo;
  }

  private void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getFechaEmision() {
    return fechaEmision;
  }

  public void setFechaEmision(String fechaEmision) {
    this.fechaEmision = fechaEmision;
  }

  public String getFechaExpiracion() {
    return fechaExpiracion;
  }

  public void setFechaExpiracion(String fechaExpiracion) {
    this.fechaExpiracion = fechaExpiracion;
  }
  
  @Override
	public String toString() {
		return "Licencia: Número: " + numeroLicencia + "\nTipo: " + tipo + "\nFecha de emisión: " + fechaEmision
				+ "\nFecha de expiracion: " + fechaExpiracion;
	}

}