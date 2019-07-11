/**
 * Realiza las funcionalidades de la aplicación
 * @author Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas
 * @version 21/09/18
 */

package aplicacion;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

import library.Departamento;
import library.Vehiculo;
import library.Viaje;
import personal.Administrador;
import personal.Chofer;
import personal.Pasajero;
import personal.Secretaria;
import personal.Usuario;
import util.JParser;
import util.Vigenere;

public class AplTransportes {
  private static final String codigo = "21";
  private static ArrayList<Viaje> viajes = new ArrayList<Viaje>();
  private static ArrayList<Usuario> usuarios;
  private static ArrayList<Chofer> choferes;
  private static ArrayList<Vehiculo> vehiculos;
  private static ArrayList<Pasajero> pasajeros;
  private static ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
  private JParser parser = new JParser();
  private boolean esAdmin = false;
  private int posUsuario = 0;
  
  public AplTransportes() {
    cargarUsuarios();
    cargarViajes();
    cargarChoferes();
    cargarVehiculos();
    cargarPasajeros();
    cargarDepartamentos();
  }
  
  public void registrarViaje(Viaje viaje) {
    viajes.add(viaje);
  }
  
  public boolean puedeIngresar(String nombreUsuario, String contrasenia) {
	esAdmin = false;
	for(int i = 0; i < usuarios.size(); i++) {
	  Usuario usuario = usuarios.get(i);
	  String nombreCifrado = usuario.getNombreUsuario();
	  String contraseniaCifrada = usuario.getContrasenna();
      if(descifrarDato(nombreCifrado).equals(nombreUsuario) && 
          descifrarDato(contraseniaCifrada).equals(contrasenia)) {
    	esAdmin = esAdministrador(nombreUsuario);
    	posUsuario = i;
        return true;
      }
	}
    return false;
  }
  
  private void cargarUsuarios() {
    try {
      usuarios = parser.parseUsuarios();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } 
  }
  
  private String descifrarDato(String dato) {
    Vigenere cifrador = new Vigenere(dato, codigo);
    return cifrador.descifrar();
  }
  
  private boolean esAdministrador(String usuario) {
    return usuario.equals("administrador");
  }
  
  public boolean getEsAdmin() {
    return esAdmin;
  }
  
  public Usuario getUsuario() {
	cargarUsuarios();
	Usuario temp = usuarios.get(posUsuario);
	if(getEsAdmin()){
      Administrador user = new Administrador(temp.getNombre(), temp.getCedula(), temp.getTelefono(), 
          temp.getDepartamento(), temp.getNombreUsuario(), temp.getContrasenna());
      return user;
	}else {
      Secretaria user = new Secretaria(temp.getNombre(), temp.getCedula(), temp.getTelefono(), 
          temp.getDepartamento(), temp.getNombreUsuario(), temp.getContrasenna());
      user.setAplicacion(this);
      return user;
	}
  }
  
  private void cargarViajes() {
	    try {
	      viajes = parser.parseViajes("viajes.json");
	    } catch (Exception e) {
	      JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    } 
  }
  
  public ArrayList<Viaje> getViajes(){
    return viajes;
  }
  
  private void cargarChoferes() {
    try {
       choferes = parser.parseChoferes("choferesDB.json");
    } catch (Exception e) {
       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } 
  }
  
  @SuppressWarnings("unchecked")
  public void choferesSort() {
    Collections.sort(choferes);
  }
  
  public ArrayList<Chofer> getChoferes(){
	  return choferes;
  }
  
  @SuppressWarnings("unchecked")
  public void viajesSort() {
    Collections.sort(viajes);
  }
  public void cargarVehiculos() {
    try {
       vehiculos = parser.parseVehiculos("vehiculosDB.json");
    } catch (Exception e) {
       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } 
  }
  
  public ArrayList<Vehiculo> getVehiculos() {
  	return vehiculos;
  }
  
  public void cargarPasajeros() {
  	try {
       pasajeros = parser.parsePasajeros("pasajerosDB.json");
    } catch (Exception e) {
       JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } 
  }
  
  public ArrayList<Pasajero> getPasajeros(){
  	return pasajeros;
  }
  
  public void cargarDepartamentos() {
    try {
      departamentos = parser.parseDepartamentos("departamentosDB.json");
   } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
   }
  }
  
  public void guardar() {
    PrintWriter a = new PrintWriter(".json");
  }
}