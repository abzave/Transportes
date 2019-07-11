package library;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import personal.Chofer;
import personal.Pasajero;
import util.Correo;

/**
 * Maneja los viajes realizados dentro del sistema.
 * 
 * @author Giancarlos Fonseca, Abraham Meza Vega y Tribeth Rivas
 * 
 * @version 19/09/18
 */


public class Viaje implements Comparable{
  private static int cantidadDeViajes = 0;
  private String consecutivo;
  private String fechaInicio;
  private String fechaFinal;
  private String fechaIngreso;
  private String estado;
  private double kilometrajeInicial;
  private double kilometrajeFinal;
  private String confeccionador;
  private Chofer chofer;
  private Direccion destino;
  private Direccion salida;
  private ArrayList<Pasajero> pasajeros;
  private Vehiculo vehiculo;
  private Departamento departamento;
  /**
   * Constructor 1 de la clase viaje, se utilizara al iniciar el programa para crear los objetos precargados
   * en el archivo JSON.
   * 
   * Viaje viaje0 new Viaje(pConsecutivo, pEstado, pConfeccionador, pSalida, pDestino, pFechaInicio, 
   * pFechaFinal, pFechaIngreso, pKilometrajeInicial, pKilometrajeFinal, pChofer, pVehiculo, pajaseros, pDepartamento);
   * 
   * @param String pConsecutivo
   * @param String pEstado
   * @param String pConfeccionador
   * @param Direccion pSalida
   * @param Direccion pDestino
   * @param String pFechaInicio
   * @param String pFechaFinal
   * @param String pFechaIngreso
   * @param double pKilometrajeIicial
   * @param double pKilometrajeFinal
   * @param Chofer pChofer
   * @param Vehiculo pVehiculo
   * @param ArrayList<Pasajero> pasajeros
   * @param String pDepartamento
   */
  public Viaje(String pConsecutivo ,String pEstado, String pConfeccionador, Direccion pSalida, Direccion pDestino, 
      String pFechaInicio, String pFechaFinal, String pFechaIngreso,double pKilometrajeInicial, double pKilometrajeFinal,
      Chofer pChofer, Vehiculo pVehiculo, ArrayList<Pasajero> pasajeros, Departamento pDepartamento) {
    cantidadDeViajes++;
    fechaIngreso = pFechaIngreso;
    consecutivo = pConsecutivo;
    departamento = pDepartamento;
    setKilometrajeInicial(pKilometrajeInicial);
    setKilometrajeFinal(pKilometrajeFinal);
    setChofer(pChofer);
    setVehiculo(pVehiculo);
    setEstado(pEstado);
    setConfeccionador(pConfeccionador);
    setSalida(pSalida);
    setDestino(pDestino);
    setFechaInicio(pFechaInicio);
    setFechaFinal(pFechaFinal);
    setPasajeros(pasajeros);
  }
  
  /**
   * Constructor 2 de la clase viaje, se utilizara cada vez que se solicite crear un viaje dentro del sistema.
   * 
   * Viaje viaje0 new Viaje(pEstado, pConfeccionador, pSalida, pDestino, pFechaInicio, 
   * pFechaFinal, pFechaIngreso, pKilometrajeInicial, pKilometrajeFinal, pajaseros, pDepartamento);
   * 
   * @param String pEstado
   * @param String pConfeccionador
   * @param Direccion pSalida
   * @param Direccion pDestino
   * @param String pFechaInicio
   * @param String pFechaFinal
   * @param String pFechaIngreso
   * @param double pKilometrajeIicial
   * @param double pKilometrajeFinal
   * @param ArrayList<Pasajero> pasajeros
   * @param String pDepartamento
   */
  public Viaje(String pEstado, String pConfeccionador, Direccion pSalida, Direccion pDestino, 
      String pFechaInicio, String pFechaFinal,double pKilometrajeInicial, ArrayList<Pasajero> pasajeros, Departamento pDepartamento) {
    cantidadDeViajes++;
    departamento = pDepartamento;
    setConsecutivo(cantidadDeViajes);
    setKilometrajeInicial(pKilometrajeInicial);
    setEstado(pEstado);
    setConfeccionador(pConfeccionador);
    setSalida(pSalida);
    setDestino(pDestino);
    setFechaInicio(pFechaInicio);
    setFechaFinal(pFechaFinal);
    setPasajeros(pasajeros);
    setFechaIngreso();
  }
  
  /**
   * Metodos accesores de la clase Viaje. 
   */

  public String getFechaInicio() {
    return fechaInicio;
  }

  public void setFechaInicio(String pFechaInicio) {
    fechaInicio = pFechaInicio;
  }

  public String getFechaFinal() {
    return fechaFinal;
  }

  public void setFechaFinal(String pFechaFinal) {
    fechaFinal = pFechaFinal;
  }

  public String getFechaIngreso() {
    return fechaIngreso;
  }

  private void setFechaIngreso() {
    Calendar calendario = Calendar.getInstance();
    Date fecha = calendario.getTime();
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yyyy");
    fechaIngreso = mascara.format(fecha);
  }

  public String getConsecutivo() {
    return consecutivo;
  }

  private void setConsecutivo(int pConsecutivo) {
    String patron = "VIA-%03d";
    consecutivo = String.format(patron, pConsecutivo);
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String pEstado) {
    estado = pEstado;
  }

  public double getKilometrajeInicial() {
    return kilometrajeInicial;
  }

  public void setKilometrajeInicial(double pKilometrajeInicial) {
    kilometrajeInicial = pKilometrajeInicial;
  }

  public double getKilometrajeFinal() {
    return kilometrajeFinal;
  }

  public void setKilometrajeFinal(double pKilometrajeFinal) {
    kilometrajeFinal = pKilometrajeFinal;
  }

  public String getConfeccionador() {
    return confeccionador;
  }
  
  private void setConfeccionador(String pConfeccionador) {
  	confeccionador = pConfeccionador;
  }
  
  public Direccion getSalida() {
    return salida;
  }

  public void setSalida(Direccion pSalida) {
    salida = pSalida;
  }
  
  public Chofer getChofer() {
    return chofer;
  }

  public void setChofer(Chofer pChofer) {
    chofer = pChofer;
  }

  public Direccion getDestino() {
    return destino;
  }
  
  public void setDestino(Direccion pDestino) {
    destino = pDestino;
  }
  
  public void setPasajeros(ArrayList<Pasajero> pasajeros) {
    this.pasajeros = pasajeros;
  }
  
  public ArrayList<Pasajero> getPasajeros(){
    return pasajeros;
  }

  public void agregarPasajero(Pasajero pasajero) {
    pasajeros.add(pasajero);
  }
  
  
  public Vehiculo getVehiculo() {
    return vehiculo;
  }

  public void setVehiculo(Vehiculo vehiculo) {
    this.vehiculo = vehiculo;
  }
  
  public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento pDepartamento) {
		departamento = pDepartamento;
	}
	public void aprobar(Chofer chofer, Vehiculo vehiculo) {
    estado = "Aprobado";
    setChofer(chofer);
    setVehiculo(vehiculo);
    Correo correo = new Correo();
    PDF pdf = new PDF("viaje.pdf");
    try {
      pdf.crear(toString());
      correo.enviarConAdjunto(chofer.getCorreo(), "", "Aproabación de viaje", "viaje.pdf");
      for(Pasajero pasajero : pasajeros) {
        correo.enviarConAdjunto(pasajero.getCorreo(), "", "Aproabación de viaje", "viaje.pdf");
      }
      JOptionPane.showMessageDialog(null, "¡Correos enviados con éxito!", "Correos enviados", 
          JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e.getClass(), "Error", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  public boolean estaAprobado() {
    return estado == "Aprobado";
  }
  
  public String getNombreChofer() {
    if(estaAprobado()) {
    	return chofer.getNombre();
    }else {
    	return "El chofer todavía no ha sido asignado";
    }
  }
  
  public String getPlacaVehiculo() {
	  if(estaAprobado()) {
	    return vehiculo.getPlaca();
	  }else {
	    return "El vehiculo todavía no ha sido asignado";
	  }
  }
  
  public int getCantidadPasajeros() {
    return pasajeros.size();
  }
  @Override
  public String toString() {
    String msg;
    msg = "Viajes totales: " + cantidadDeViajes + "\n";
    msg += "Fecha del viaje: " + fechaInicio + "\n";
    msg += "Fecha de regreso: " + fechaFinal + "\n";
    msg += "Fecha en la que registró el viaje: " + fechaIngreso + "\n";
    msg += "Consecutivo: " + consecutivo + "\n";
    msg += "Estado: " + estado + "\n";
    msg += "Kilometraje inicial: " + kilometrajeInicial  + "\n";
    msg += "Kilometraje final: " + kilometrajeFinal  + "\n";
    msg += "Confeccionado por: " + getConfeccionador() + "\n";
    msg += "Chofer: " + getNombreChofer() + "\n";
    msg += "Punto de salida: " + salida.toString() +"\n";
    msg += "Destino: " + destino.toString() + "\n";
    msg += "Placa del vehiculo: " + getPlacaVehiculo() + "\n";
    msg += "Departamento o escuela: "+getDepartamento() +"\n";
    msg += "Lista de pasajeros:\n";
    for(int i = 0; i < pasajeros.size(); i++) {
      Pasajero pasajero = pasajeros.get(i);
      msg += pasajero.toString() + "\n";
    }
    return msg;
  }
  
  public int compareTo(Object o) {
	  try {
		  Departamento departamento = (Departamento)o;
		  return departamento.getCantViajes() - this.departamento.getCantViajes();
	  }catch(Exception e) {
		  return 0;
	  }
  }
  
}