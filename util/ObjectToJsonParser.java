package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import library.Departamento;
import library.Direccion;
import library.Empresa;
import library.Licencia;
import library.Mantenimiento;
import library.Vehiculo;
import library.Viaje;
import personal.Chofer;
import personal.Pasajero;
import personal.Secretaria;

public class ObjectToJsonParser {
  @SuppressWarnings("unchecked")
  public JSONObject parseDireccion(Direccion direccion){
    JSONObject obj = new JSONObject();
    obj.put("provincia",direccion.getProvincia());
    obj.put("canton",direccion.getCanton());
    obj.put("distrito",direccion.getDistrito());
    obj.put("sennas",direccion.getSennas());
    return obj;
  }
  @SuppressWarnings("unchecked")
  public JSONObject parseEmpresa(Empresa empresa){
    JSONObject obj = new JSONObject();
    obj.put("razonSocial",empresa.getRazonSocial());
    obj.put("cedulaJuridica",empresa.getCedulaJuridica());
    obj.put("telefono",empresa.getTelefono());
    obj.put("direccion",parseDireccion(empresa.getDireccion()));
    return obj;
  }
  
  @SuppressWarnings("unchecked")
  public String parseVehiculo(Vehiculo vehiculo){
    try {
      JSONObject obj = new JSONObject();
      obj.put("placa",vehiculo.getPlaca());
      obj.put("annoFabricacion",vehiculo.getAnnoFabricacion());
      obj.put("color",vehiculo.getColor());
      obj.put("marca",vehiculo.getMarca());
      obj.put("vin",vehiculo.getVin());
      obj.put("sede",vehiculo.getSede());
      obj.put("estado",vehiculo.getEstado());
      obj.put("capacidad",vehiculo.getCapacidad());
      obj.put("kilometraje",vehiculo.getKilometraje());
      obj.put("mantenimientos",parseMantenimientos(vehiculo.getMantenimientos()));
      return obj.toJSONString();
    }catch(Exception e) {
      return null;
    }
  }
  public JSONArray parseMantenimientos(ArrayList<Mantenimiento> mantenimientos) {
    JSONArray obj = new JSONArray();
    for(Mantenimiento mantenimiento: mantenimientos) {
      obj.add(parseMantenimiento(mantenimiento));
    }
    return obj;
  }
  @SuppressWarnings("unchecked")
  public JSONObject parseMantenimiento(Mantenimiento mantenimiento){
    JSONObject obj = new JSONObject();
    obj.put("fechaInicio",mantenimiento.getFechaInicio());
    obj.put("monto",mantenimiento.getMonto());
    obj.put("detalle",mantenimiento.getDetalle());
    obj.put("tipo",mantenimiento.getTipo());
    obj.put("empresa",parseEmpresa(mantenimiento.getEmpresa()));
    return obj;
  }
  
  @SuppressWarnings("unchecked")
  public JSONObject parseChofer(Chofer chofer){
    try {  
      JSONObject obj = new JSONObject();
      obj.put("nombre",chofer.getNombre());
      obj.put("cedula",chofer.getCedula());
      obj.put("telefono",chofer.getTelefono());
      obj.put("correo",chofer.getCorreo());
      obj.put("licencias",parseLicencias(chofer.getLicencias()));
      return obj;
    }catch(Exception e) {
      return null;
    }
  }
  
  @SuppressWarnings("unchecked")
  public JSONObject parsePasajero(Pasajero pasajero){
    JSONObject obj = new JSONObject();
    obj.put("nombre",pasajero.getNombre());
    obj.put("cedula",pasajero.getCedula());
    obj.put("telefono",pasajero.getTelefono());
    obj.put("correo",pasajero.getCorreo());
    obj.put("id", pasajero.getId());
    return obj;
  }
  public JSONArray parsePasajeros(ArrayList<Pasajero> pasajeros) {
    JSONArray obj = new JSONArray();
    try {
      for(Pasajero pasajero: pasajeros) {
        obj.add(parsePasajero(pasajero));
      }
    }catch(Exception e) {
      return null;
    }
    return obj;
  }
  
  @SuppressWarnings("unchecked")
  public JSONObject parseLicencia(Licencia licencia){
    JSONObject obj = new JSONObject();
    obj.put("fechaEmision",licencia.getFechaEmision());
    obj.put("fechaExpiracion",licencia.getFechaExpiracion());
    obj.put("numeroLicencia",licencia.getNumeroLicencia());
    obj.put("tipo",licencia.getTipo());
    return obj;
  }
  
  public JSONArray parseLicencias(ArrayList<Licencia> licencias) {
    JSONArray obj = new JSONArray();
    for(Licencia licencia: licencias) {
      obj.add(parseLicencia(licencia));
    }
    return obj;
  }
  
  @SuppressWarnings("unchecked")
  public JSONObject parseViaje(Viaje viaje){
    JSONObject obj = new JSONObject();
    obj.put("consecutivo",viaje.getConsecutivo());
    obj.put("fechaInicio",viaje.getFechaInicio());
    obj.put("fechaFinal",viaje.getFechaFinal());
    obj.put("fechaIngreso",viaje.getFechaIngreso());
    obj.put("estado",viaje.getEstado());
    obj.put("kilometrajeInicial",viaje.getKilometrajeInicial());
    obj.put("kilometrajeFinal",viaje.getKilometrajeFinal());
    obj.put("confeccionador",viaje.getConfeccionador());
    obj.put("chofer",parseChofer(viaje.getChofer()));
    obj.put("destino",parseDireccion(viaje.getDestino()));
    obj.put("salida",parseDireccion(viaje.getSalida()));
    obj.put("pasajeros",parsePasajeros(viaje.getPasajeros()));
    obj.put("vehiculo",parseVehiculo(viaje.getVehiculo()));
    obj.put("departamento", parseDepartamento(viaje.getDepartamento()));
    return obj;
  }
  @SuppressWarnings("unchecked")
  public JSONObject parseSecretaria(Secretaria secretaria){
    JSONObject obj = new JSONObject();
    obj.put("nombre",secretaria.getNombre());
    obj.put("cedula",secretaria.getCedula());
    obj.put("telefono",secretaria.getTelefono());
    obj.put("departamento",secretaria.getDepartamento());
    obj.put("nombreUsuario",secretaria.getNombreUsuario());
    obj.put("contrasenna",secretaria.getContrasenna());
    obj.put("pasajeros",parsePasajeros(secretaria.getPasajeros()));
    return obj;
  }
  
  public String save(String nombreArchivo, String toSave) {
      String contenido = "";
      Archivo json = new Archivo(nombreArchivo);
      try {
      contenido = json.leer();
      char ultimo = contenido.charAt(contenido.length() - 1);
      contenido = contenido.substring(0, contenido.length() - 1);
      contenido += "," + toSave + ultimo;
      json.escribir(contenido);
    return "Base actualizada!";
    } catch (FileNotFoundException e) {
      contenido +=  "[" + toSave + "]";
      try {
      json.escribir(contenido);
    } catch (IOException e1) {
        return e1.getMessage();
    }
    }catch (IOException e) {
        return e.getMessage();
    }catch (Exception e) {
      contenido +=  "[" + toSave + "]";
      try {
      json.escribir(contenido);
    } catch (IOException e1) {
      return e1.getMessage();
    }
  }
      return "Base actualizada!";
    
  }
  
  @SuppressWarnings("unchecked")
  public JSONObject parseDepartamento(Departamento departamento){
      JSONObject obj = new JSONObject();
      obj.put("nombre",departamento.getNombre());
      obj.put("cantViajesD",departamento.getCantViajes());
      return obj;
    }
  
}