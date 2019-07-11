package ui;

import java.util.ArrayList;

import javax.swing.JList;

import library.Vehiculo;
import library.Viaje;
import personal.Chofer;
import util.Correo;

import static util.Fechas.distanciaEntreFechas;

public class AprobarViajeUI extends UiFrame{
	private ArrayList<Viaje> viajes;
	private ArrayList<Chofer> choferes;
	private ArrayList<Vehiculo> vehiculos;
	private ArrayList<Viaje> viajesFiltrados;
	private ArrayList<Chofer> choferesFiltrados;
	private ArrayList<Vehiculo> vehiculosFiltrados;
	private JList<String> viajeSeleccionado;
	private JList<String> choferSeleccionado;
	private JList<String> vehiculoSeleccionado;
	private String[] viajesFiltradosTexto;
	private String[] choferesFiltradosTexto;
	private String[] vehiculosFiltradosTexto;
	
	
	public AprobarViajeUI(ArrayList<Viaje> pViajes,ArrayList<Chofer> pChoferes, ArrayList<Vehiculo> pVehiculos) {
		super("Aprobar viaje", 500, 300, 200, 200);
		viajes = pViajes;
		choferes = pChoferes;
		vehiculos = pVehiculos;
		viajesFiltrados = new ArrayList<Viaje>();
		choferesFiltrados = new ArrayList<Chofer>();
		vehiculosFiltrados = new ArrayList<Vehiculo>();
		viajesFiltradosTexto = new String[viajes.size()+1];
		choferesFiltradosTexto = new String[choferes.size()+1];
		vehiculosFiltradosTexto = new String[vehiculos.size()+1];
		viajesFiltradosTexto[0] = "Consecutivo        Fecha";
		choferesFiltradosTexto[0] = "Nombre        Telefono";
		vehiculosFiltradosTexto[0] = "Placa        Sede";
		filtrarViajes();
	}
	public void filtrarViajes() {
		for(Viaje viaje : viajes) {
			if(!viaje.getEstado().equals("Aprobado")) {
				viajesFiltrados.add(viaje);
			}
		}
		for (int i = 0; i<viajesFiltrados.size();i++) {
			viajesFiltradosTexto[i+1] = viajes.get(i).getConsecutivo()+"                 "+viajes.get(i).getFechaIngreso();
		}
		viajeSeleccionado = crearMultipleSeleccion("Seleccione un viaje", viajesFiltradosTexto, false);
		if(viajeSeleccionado.getSelectedIndex()>0) {
			filtrarChoferes(viajesFiltrados.get(viajeSeleccionado.getSelectedIndex()-1));
		}
		dispose();
	}
	public void filtrarChoferes(Viaje pViaje) {
		boolean seleccionado;
		for(Chofer chofer : choferes) {	
			seleccionado = true;
			for(Viaje viaje : viajes) {
				if(chofer.toString().equals(viaje.getChofer().toString())) {
					if(distanciaEntreFechas(viaje.getFechaFinal(), pViaje.getFechaInicio())<1) {
						seleccionado = false;
						break;
					}
				}
			}
			if(seleccionado) {
				choferesFiltrados.add(chofer);
			}
		}
		for (int i = 0; i<choferesFiltrados.size();i++) {
			choferesFiltradosTexto[i+1] = choferes.get(i).getNombre()+"                 "+choferes.get(i).getTelefono();
		}
		choferSeleccionado = crearMultipleSeleccion("Seleccione un chofer", choferesFiltradosTexto, false);
		if(choferSeleccionado.getSelectedIndex()>0) {
			filtrarVehiculos(pViaje);
		}
	}
	public void filtrarVehiculos(Viaje pViaje) {
		boolean seleccionado;
		for(Vehiculo vehiculo : vehiculos) {	
			seleccionado = true;
			for(Viaje viaje : viajes) {
				if(vehiculo.toString().equals(viaje.getChofer().toString())) {
					if(distanciaEntreFechas(viaje.getFechaFinal(), pViaje.getFechaInicio())<1) {
						if(pViaje.getCantidadPasajeros()<vehiculo.getCapacidad()) {
							seleccionado = false;
							break;
						}
					}
				}
			}
			if(seleccionado) {
				vehiculosFiltrados.add(vehiculo);
			}
		}
		for (int i = 0; i<vehiculosFiltrados.size();i++) {
			vehiculosFiltradosTexto[i+1] = vehiculos.get(i).getPlaca()+"                 "+vehiculos.get(i).getSede();
		}
		vehiculoSeleccionado = crearMultipleSeleccion("Seleccione un vehiculo", vehiculosFiltradosTexto, false);
		if(vehiculoSeleccionado.getSelectedIndex()>0) {
			viajesFiltrados.get(viajeSeleccionado.getSelectedIndex()-1).aprobar(choferesFiltrados.get(choferSeleccionado.getSelectedIndex()-1),
					vehiculosFiltrados.get(vehiculoSeleccionado.getSelectedIndex()-1));
		}
	}
	
}
