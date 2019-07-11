package ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import personal.Pasajero;
import personal.Secretaria;

@SuppressWarnings("serial")
public class RegistrarPasajeroUI extends UiFrame {
	private Secretaria secretaria;
	private JTextField nombre;
	private JTextField cedula;
	private JTextField telefono;
	private JTextField correo;
	
	
	public RegistrarPasajeroUI(Secretaria pSecretaria) {
		super("Registrar pasajero", 600, 400, 600, 525);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		secretaria = pSecretaria;	
		initComponents();
	}
	
  private void initComponents() {
	  crearLabel("Registrar pasajero",180,0,300,40,25);
	  crearLabel("Nombre", 20, 55, 100, 40, 25);
  	crearLabel("Cedula", 20, 142, 150, 40, 25);
  	crearLabel("Telefono", 20, 230, 150, 40, 25);
  	crearLabel("Correo", 20, 310, 150, 40, 25);
  	nombre = crearTextField(200, 55, 300, 50, 25);
  	cedula = crearTextField(200, 142, 300, 50, 25);
  	telefono = crearTextField(200, 230, 300, 50, 25);
  	correo = crearTextField(200, 310, 300, 50, 25);
  	crearBoton("Registrar", 200, 398, 200, 75, 25).addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				registrar();
			} 
		});
  	repaint();
  }
	
	private void registrar() {
		if(!secretaria.registrarPasajero(new Pasajero(nombre.getText(), cedula.getText(), telefono.getText(), correo.getText()))) {
			crearLabel("¡Error, pasajero ya está registrado!", 100, 280, 400, 40, 25);
			repaint();
		}else {
			dispose();
		}
	}
}
