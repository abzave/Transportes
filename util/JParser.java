	package util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import library.Departamento;
import library.Direccion;
import library.Empresa;
import library.Licencia;
import library.Mantenimiento;
import library.Vehiculo;
import library.Viaje;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import personal.Chofer;
import personal.Pasajero;
import personal.Usuario;

public class JParser {
	
	private JSONParser parser = new JSONParser();
	private JSONArray obj;
	
	public ArrayList<Pasajero> parsePasajeros(String dir){
		try {
			return parsePasajeros((JSONArray) parser.parse(new FileReader(dir)));
		} catch (IOException | ParseException e) {
			System.out.println("No pude leer el archivo");
		}
		return null;
	}
	
	private ArrayList<Pasajero> parsePasajeros(JSONArray obj){
		ArrayList<Pasajero> parsed = new ArrayList<Pasajero>();
		JSONObject actual;
		try {
			for(Object ob : obj) {
				actual = (JSONObject)ob;
				parsed.add(new Pasajero(
						(String)actual.get("nombre"),
						(String)actual.get("cedula"),
						(String)actual.get("telefono"),
						(String)actual.get("correo"),
						((Long)actual.get("id")).intValue()));
			}
		}catch(Exception e) {
			return null;
		}
		return parsed;
	}
	
	public ArrayList<Viaje> parseViajes(String dir)  {
		ArrayList<Viaje> parsed = new ArrayList<Viaje>();
		try {
				obj = (JSONArray) parser.parse(new FileReader(dir));
				JSONObject actual;
				for(Object ob : obj) {
					actual = (JSONObject)ob;
					parsed.add(new Viaje(
							(String)actual.get("consecutivo"),
							(String)actual.get("estado"),
							(String)actual.get("confeccionador"),
							parseDireccion((JSONObject)actual.get("salida")),
							parseDireccion((JSONObject)actual.get("destino")),
							(String)actual.get("fechaInicio"),
							(String)actual.get("fechaFinal"),
							(String)actual.get("fechaIngreso"),
							(double)actual.get("kilometrajeInicial"),
							(double)actual.get("kilometrajeFinal"),
							parseChofer((Object)actual.get("chofer")),
							parseVehiculo((Object)actual.get("vehiculo")),
							parsePasajeros((JSONArray)actual.get("pasajeros")),
							parseDepartamento((JSONObject)actual.get("departamento"))
									));
				}
		}catch(Exception e) {
		//	System.out.println(e.getMessage());
		}
		
			return parsed;
	}
	
	public ArrayList<Chofer> parseChoferes(String dir){
		try {
			return parseChoferes((JSONArray) parser.parse(new FileReader(dir)));
		} catch (IOException | ParseException e) {
			System.out.println("No pude leer el archivo");
		}
		return null;
	}
	
	private ArrayList<Chofer> parseChoferes(JSONArray obj){
		ArrayList<Chofer> parsed = new ArrayList<Chofer>();
		JSONObject actual;
		try {
			for(Object ob : obj) {
				actual = (JSONObject)ob;
				parsed.add(parseChofer(actual));
			}
		}catch(Exception e) {
			return null;
		}
		return parsed;
	}
	
	public Chofer parseChofer(Object obj) {
		try {
			JSONObject object = (JSONObject)obj;
		  return new Chofer((String)object.get("nombre"), (String)object.get("cedula"),
			  (String)object.get("telefono"), (String)object.get("correo"), parseLicencias((JSONArray)object.get("licencias")),
			  ((Long)object.get("cantViajes")).intValue());
		}catch(java.lang.ClassCastException e) {
			return null;
		}
	}
	
	private ArrayList<Licencia> parseLicencias(JSONArray obj){
		ArrayList<Licencia> parsed = new ArrayList<Licencia>();
		JSONObject actual;
		try {
			for(Object ob : obj) {
				actual = (JSONObject)ob;
				parsed.add(new Licencia(
						(String)actual.get("tipo"),
						(String)actual.get("fechaEmision"),
						(String)actual.get("fechaExpiracion"),
						((Long)actual.get("numeroLicencia")).intValue()));
			}
		}catch(Exception e) {
			return null;
		}
		return parsed;
	}
	
	public ArrayList<Vehiculo> parseVehiculos(String dir) throws FileNotFoundException, IOException, ParseException{
		obj = (JSONArray) parser.parse(new FileReader(dir));
		ArrayList<Vehiculo> parsed = new ArrayList<Vehiculo>();
		JSONObject actual;
		for(Object ob : obj) {
			parsed.add(parseVehiculo(ob));
		}
		return parsed;
	}
	
	public Vehiculo parseVehiculo(Object obj) {
		try {
			JSONObject object = (JSONObject)obj;
			return new Vehiculo((String)object.get("placa"), (String)object.get("annoFabricacion"), (String)object.get("color"),
				(String) object.get("marca"), (String)object.get("vin"),
				(String)object.get("sede"), ((Long)object.get("capacidad")).intValue(),((Long) object.get("kilometraje")).intValue(),
				parseMantenimientos((JSONArray)object.get("mantenimientos")));
		}catch(Exception e) {
			return null;
		}
	}
	
	public ArrayList<Mantenimiento> parseMantenimientos(JSONArray obj){
		ArrayList<Mantenimiento> parsed = new ArrayList<Mantenimiento>();
		JSONObject actual;
		for(Object ob : obj) {
			actual = (JSONObject)ob;
			parsed.add(new Mantenimiento(
					(String)actual.get("fechaInicio"),
					(double)actual.get("monto"),
					(String)actual.get("detalle"),
					(String)actual.get("tipo"),
					parseEmpresa(actual.get("empresa"))));
		}
		return parsed;
	}
	
	public Empresa parseEmpresa(Object ob) {
		JSONObject obj = (JSONObject)ob;
		return new Empresa((String)obj.get("razonSocial"),
				(String)obj.get("cedulaJuridica"),
				(String)obj.get("telefono"),
				parseDireccion((JSONObject)obj.get("direccion")));
	}
	
	public Direccion parseDireccion(JSONObject object) {
		return new Direccion((String)object.get("provincia"), (String)object.get("canton"),
				(String)object.get("distrito"), (String)object.get("sennas"));
	}
	
	@SuppressWarnings("unused")
	public ArrayList<Usuario> parseUsuarios() throws FileNotFoundException, IOException, ParseException{
		obj = (JSONArray) parser.parse(new FileReader("usuariosDB.json"));
		ArrayList<Usuario> parsed = new ArrayList<Usuario>();
		JSONObject actual;
		for(Object ob : obj) {
			actual = (JSONObject)ob;
			parsed.add(new Usuario(
					(String)actual.get("nombre"),
					(String)actual.get("cedula"),
					(String)actual.get("telefono"),
					(String)actual.get("departamento"),
					(String)actual.get("nombreUsuario"),
					(String)actual.get("contrasenna")));
		}
		return parsed;
	}
	
	public ArrayList<Departamento> parseDepartamentos(String dir){
	  try {
      JSONArray obj = (JSONArray) parser.parse(new FileReader(dir));
      ArrayList<Departamento> parsed = new ArrayList<Departamento>();
      JSONObject actual;
        for(Object ob : obj) {
          actual = (JSONObject)ob;
          parsed.add(parseDepartamento(actual));
        }
      return parsed;
    } catch (IOException | ParseException e) {
      System.out.println("No pude leer el archivo");
    }
    return null;
	}
	
	public Departamento parseDepartamento(JSONObject object) {
		return new Departamento((String)object.get("nombre"), ((Long)object.get("cantViajesD")).intValue());
	}
	
}