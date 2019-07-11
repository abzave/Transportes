package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import library.Direccion;
import library.Empresa;

@SuppressWarnings("serial")
public class RegistrarDireccionUI extends UiFrame {
	
  private JTextField provincia;
  private JTextField canton;
  private JTextField distrito;
  private JTextField sennas;
  
  
	public RegistrarDireccionUI(RegistrarEmpresaUI empresa) {
		super("Registrar direccion", 700, 400, 600, 370);
		setDefaultCloseOperation(UiFrame.DISPOSE_ON_CLOSE);
		initComponents(empresa);
	}
	
	public void initComponents(RegistrarEmpresaUI empresa) {
		crearLabel("Provincia", 20, 10, 200, 30, 25);
		provincia = crearTextField(150, 15, 200, 30, 25);
		crearLabel("Canton", 20, 50, 200, 30, 25);
		canton = crearTextField(150, 55, 200, 30, 25);
		crearLabel("Distrito", 20, 90, 200, 30, 25);
		distrito = crearTextField(150, 95, 200, 30, 25);
		crearLabel("Señas", 20, 130, 200, 30, 25);
		sennas = crearTextField(150, 135, 400, 30, 25);
		crearBoton("Registrar", 175, 200, 200, 100, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				empresa.setDireccion(new Direccion(provincia.getText(), canton.getText(), distrito.getText(), sennas.getText()));
				dispose();
			}
		});;
		repaint();
	}
	
	

}