package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import personal.Secretaria;

@SuppressWarnings("serial")
public class SolicitarViajeUI extends UiFrame {
	/*
	 * 
      ArrayList<Pasajero> pasajeros)
	 */
	private Secretaria confeccionador;
	private JTextField provincia1;
	private JTextField canton1;
	private JTextField distrito1;
	private JTextField sennas1;
	private JTextField provincia2;
	private JTextField canton2;
	private JTextField distrito2;
	private JTextField sennas2;
	private JTextField fechaInicio;
	private JTextField fechaFinal;
	private JTextField kilometrajeInicial;
	private JList<String>listaPasajeros  ;
	
	
	public SolicitarViajeUI(String pTitulo, Secretaria pConfeccionador) {
		super(pTitulo, 400, 200, 1080, 620);
		confeccionador = pConfeccionador;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponents();
	}
	public void initComponents() {
		crearLabel("Dirección de salida", 400, 10, 300, 30, 25);
		crearLabel("Provincia",10,50,200,30,25);
		provincia1 = crearTextField(120, 55, 200, 30, 25);
		crearLabel("Canton",370,50,200,30,25);
		canton1 = crearTextField(460, 55, 200, 30, 25);
		crearLabel("Distrito",730,50,200,30,25);
		distrito1 = crearTextField(820, 55, 200, 30, 25);
		crearLabel("Direccion por señas",10,100,250,30,25);
		sennas1 = crearTextField(270, 105, 700, 30, 25);
		crearLabel("Dirección de destino", 400, 150, 300, 30, 25);
		crearLabel("Provincia",10,190,200,30,25);
		provincia1 = crearTextField(120, 195, 200, 30, 25);
		crearLabel("Canton",370,190,200,30,25);
		canton1 = crearTextField(460, 195, 200, 30, 25);
		crearLabel("Distrito",730,190,200,30,25);
		distrito1 = crearTextField(820, 195, 200, 30, 25);
		crearLabel("Direccion por señas",10,240,250,30,25);
		sennas1 = crearTextField(270, 245, 700, 30, 25);
		crearLabel("Fecha de salida",10,300,250,30,25);
		fechaInicio = crearTextField(200, 305, 200, 30, 25);
		crearLabel("Fecha de retorno",500,300,250,30,25);
		fechaInicio = crearTextField(700, 305, 200, 30, 25);
		crearLabel("Kilometraje inicial",10,370,250,30,25);
		kilometrajeInicial = crearTextField(270, 375, 250, 30, 25);
		String[] pasajeros = new String[confeccionador.getPasajeros().size()];
		for(int i = 0; i < pasajeros.length; i++) {
			pasajeros[i] = confeccionador.getPasajeros().get(i).toString();
		}
		crearBoton("Seleccionar pasajeros", 80, 470, 300, 100, 25).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listaPasajeros = crearMultipleSeleccion("Seleccione los pasajeros", pasajeros, true);
			}
		});;
		
		crearBoton("Aceptar", 700, 470, 290, 100, 25).addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(listaPasajeros.getSelectedIndices().length);
			}
		});;
		repaint();
	}

}
