package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import library.Viaje;

@SuppressWarnings("serial")
public class FIltradoUI extends UiFrame {
	private int tipoFiltrado;
	private ArrayList<Viaje> viajes;
	private ArrayList<Viaje> viajesFiltrados;
	private String[] viajesFiltradosTexto;
	private JLabel tipoActual;
	private JLabel tip;
	private JTextField dato;
	private JList<String> seleccionadorDeFiltro;
	private JList<String> seleccionadorDeViaje;
	private String[] tipos = {"Fecha","Estado: En confección","Estado: Aprobado","Estado: Cancelado","Estado: No aprobado", "Destino"};
	private String[] info = {"Formato dd/mm/aaa", "Formato Provincia-Cantón-Distrito "};
	
	public FIltradoUI(ArrayList<Viaje> pViajes) {
		super("Menu filtrado", 700, 300, 450, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viajes = pViajes;
		viajesFiltrados = new ArrayList<Viaje>();
		viajesFiltradosTexto = new String[viajes.size()+1];
		viajesFiltradosTexto[0] = "     ID            Fecha de ingreso           Estado                                                                              "
				+ "           Destino                                                                                   Fecha de inicio";
		initComponents();
	}
	public void initComponents() {
		tipoActual = crearLabel("Filtrando por: "+tipos[tipoFiltrado], 20,20, 600, 30, 25);
		tip = crearLabel(info[0], 20, 200, 600, 30, 25);
		dato = crearTextField(20, 260, 400, 50, 25);
		
		crearBoton("Escoger filtrado", 85, 80, 270,100,25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarFiltrado();
			}
		});
		crearBoton("Filtrar", 85, 350, 270, 100, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				filtrar();
			}
		});
		repaint();
	}
	
	public void filtrar(){
		limpiarViajesFiltrados();
		Viaje actual = null;
		for(int i = 0; i<viajes.size(); i++) {
			actual = viajes.get(i);
  		if(tipoFiltrado == 0) {	
				if(actual.getFechaIngreso().equals(dato.getText())) {
  				annadirViaje(actual);
  			}
  		}else if(tipoFiltrado == 1) {
  			if(actual.getEstado().equals("En confeccion")) {
  				annadirViaje(actual);
  			}
  		}else if(tipoFiltrado == 2) {
  			if(actual.getEstado().equals("Aprobado")) {
  				annadirViaje(actual);
  			}
  		}else if(tipoFiltrado == 3) {
  			if(actual.getEstado().equals("Cancelado")) {
  				annadirViaje(actual);
  			}
  		}else if(tipoFiltrado == 4) {
  			if(actual.getEstado().equals("No aprobado")) {
  				annadirViaje(actual);
  			}
  		}else {
  			String[] direccion = dato.getText().split("-");
  			try {
  				if(direccion[0].equals(actual.getDestino().getProvincia()) && direccion[1].equals(actual.getDestino().getCanton())
  						&& direccion[2].equals(actual.getDestino().getDistrito())) {
  					annadirViaje(actual);
  				}
  			}catch(Exception e) {
  				
  			}
  		}
		}
		mostrarOpcionesFiltrado();
		
	}
	
	public void annadirViaje(Viaje actual) {
		viajesFiltrados.add(actual);
		viajesFiltradosTexto[viajesFiltrados.size()] = actual.getConsecutivo()+"              "+actual.getFechaIngreso()+"              "+
		actual.getEstado()+"                 "+actual.getDestino()+"        "+actual.getFechaInicio();
	}
	
	public void mostrarOpcionesFiltrado() {
		seleccionadorDeViaje = crearMultipleSeleccion("Seleccione un viaje", viajesFiltradosTexto, false);
		if(seleccionadorDeViaje.getSelectedIndex()>0){
  		JList<String> opcion = crearMultipleSeleccion("Qué desea hacer con el viaje", new String[] {"Ver detalle","Cancelar", "Salir"}, false);
  		if(opcion.getSelectedIndex() == 0) {
  			new ListadosUI("Información del viaje", viajesFiltrados.get(seleccionadorDeViaje.getSelectedIndex()-1).toString(), 400, 200, 1080, 720, 20);
  		}else if(opcion.getSelectedIndex() == 1) {
  			crearMultipleSeleccion("Viaje cancelado con éxito", new String[] {"Viaje cancelado con éxito"}, false);
  		}
		}
	}
	public void cambiarInputYTip(boolean control) {
		dato.setVisible(control);
		tip.setVisible(control);
	}
	
	public void limpiarViajesFiltrados() {
		viajesFiltrados.clear();
		for(int i = 1; i<viajesFiltradosTexto.length; i++) {
			viajesFiltradosTexto[i] = null;
		}
	}
	
	public void cambiarFiltrado() {
		seleccionadorDeFiltro = crearMultipleSeleccion("Seleccione el tipo",tipos,false);
		tipoFiltrado = seleccionadorDeFiltro.getSelectedIndex();
		if(tipoFiltrado != -1) {
  		tipoActual.setText("Filtrando por: "+tipos[tipoFiltrado]);
  		if(tipoFiltrado == 0 || tipoFiltrado == 5) {
  			cambiarInputYTip(true);
  			if(tipoFiltrado == 0) {
  				tip.setText(info[0]);
  			}else {
  				tip.setText(info[1]);
  			}
  		}else {
  			cambiarInputYTip(false);
  		}
		}
	}

}
