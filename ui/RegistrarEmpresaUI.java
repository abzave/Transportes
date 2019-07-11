package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import library.Direccion;
import library.Empresa;


@SuppressWarnings("serial")
public class RegistrarEmpresaUI extends UiFrame {
	
	private JTextField razonSocial;
  private JTextField cedulaJuridica;
  private JTextField telefono;
  private Direccion direccion;
  
  
	public RegistrarEmpresaUI(RegistrarMantenimientoUI mantenimiento) {
		super("Registrar empresa", 700, 200, 600, 320);
		setDefaultCloseOperation(UiFrame.DISPOSE_ON_CLOSE);
		initComponents(mantenimiento);
	}
	
	public void initComponents(RegistrarMantenimientoUI mantenimiento) {
		crearLabel("Razón social", 20, 10, 200, 30, 25);
		razonSocial = crearTextField(300, 15, 200, 30, 25);
		crearLabel("Cédula Juridica", 20, 50, 200, 30, 25);
		cedulaJuridica = crearTextField(300, 55, 200, 30, 25);
		crearLabel("Telefono", 20, 90, 200, 30, 25);
		telefono = crearTextField(300, 95, 200, 30, 25);
		crearBoton("Añadir direccion", 20, 175, 250, 100, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registrarDireccion();
			}
		});
		crearBoton("Registrar", 320, 175, 250, 100, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mantenimiento.setEmpresa(new Empresa(razonSocial.getText(), cedulaJuridica.getText(), telefono.getText(), direccion));
				dispose();
			}
		});
		repaint();
	}
	
	public void registrarDireccion() {
		RegistrarDireccionUI dir = new RegistrarDireccionUI(this);		
	}
	public void setDireccion(Direccion pDireccion) {
		direccion = pDireccion;
	}

}