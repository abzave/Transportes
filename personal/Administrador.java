package personal;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import aplicacion.AplTransportes;
import library.Vehiculo;
import personal.Secretaria;
import util.Correo;
import util.ObjectToJsonParser;
import util.Vigenere;

public class Administrador extends Usuario {

	private AplTransportes aplicacion;
	private static final String codigo = "21";
	
	public Administrador(String pNombre, String pCedula, String pTelefono, String pDepartamento, 
	    String pNombreUsuario, String pContrasenna) {
	  super(pNombre, pCedula, pTelefono, pDepartamento, pNombreUsuario, pContrasenna);
	}
	
	public AplTransportes getAplicacion() {
		return aplicacion;
	}
	
	public void setAplicacion(AplTransportes pAplicacion) {
		aplicacion = pAplicacion;
	}
	
	public void registrarSecretaria(String correo, String nombre, String cedula, String telefono, 
	    String departamento) throws AddressException, MessagingException {
      String contrasenia = generarContrasenia();
      Correo correoPassword = new Correo();
      correoPassword.enviar(correo, "Su contraseña es: " + contrasenia, 
          "Contraseña de ingreso al sistema");
      nombre = cifrarDato(nombre);
      cedula = cifrarDato(cedula);
      telefono = cifrarDato(telefono);
      departamento = cifrarDato(departamento);
      correo = cifrarDato(correo);
      contrasenia = cifrarDato(contrasenia);
      Secretaria secretaria = new Secretaria(nombre, cedula, telefono, departamento, correo, contrasenia);
      ObjectToJsonParser baseDeDatos = new ObjectToJsonParser();
      String contenido = baseDeDatos.parseSecretaria(secretaria).toJSONString();
      baseDeDatos.save("usuariosDB.json", contenido);
	}
	
	private String generarContrasenia() {
      String abecedarioMayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      String abecedarioMinus = "abcdefghijklmnopqrstuvwxyz";
      String caracteresEspeciales = "!#$?@^~";
      String contrasenia = "";
      Random rng = new Random(System.nanoTime());
      for(int i = 0; i < 8; i++) {
        if(i % 3 == 0) {
          contrasenia += abecedarioMayus.charAt(rng.nextInt(26));
        }else if (i % 3 == 1) {
          contrasenia += abecedarioMinus.charAt(rng.nextInt(26));
        }else {
          contrasenia += caracteresEspeciales.charAt(rng.nextInt(7));
        }
      }
      Integer num = rng.nextInt(10000);
      return contrasenia += num.toString();
	}
	
  private String cifrarDato(String dato) {
    Vigenere cifrador = new Vigenere(dato, codigo);
    return cifrador.cifrar();
  }
  public void annadirVehiculo(Vehiculo vehiculo) {
  	aplicacion.getVehiculos().add(vehiculo);
  }
  
}