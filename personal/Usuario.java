/**
 * Declaracion de la clase Usuario, maneja la informacion de los usuarios en el sistema.
 * 
 * @author Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas.
 * 
 * @version 21/09/18
 */

package personal;

public class Usuario extends Persona{
	
	protected String departamento;
	protected String nombreUsuario;
	protected String contrasenna;
  
  /**
   * Constructor de la clase Usuario, se utiliza en las clases Administrador y Secretaria,
   * puesto que las anteriores heredan de esta clase.
   * 
   * Usuario usuario= new Usuario(pNombre, pCedula, pTelefono, pDepartamento, pNombreUsuario, pContrasenna);
   * 
   * @param String pNombre
   * @param String pCedula
   * @param String pTelefono
   * @param String pDepartamento
   * @param String pNombreUsuario
   * @param String pContrasenna
   */
	
  public Usuario(String pNombre, String pCedula, String pTelefono, String pDepartamento, String pNombreUsuario, String pContrasenna) {
    super(pNombre, pCedula);
    telefono = pTelefono;
    departamento = pDepartamento;
    nombreUsuario = pNombreUsuario;
    contrasenna = pContrasenna;
  }

  /**
   * Metodos accesores de la clase Usuario. 
   */
  
	public String getDepartamento() {
		return departamento;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}
  
}
