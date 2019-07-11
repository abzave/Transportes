package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import library.Mantenimiento;
import library.Vehiculo;

@SuppressWarnings("serial")
public class RegistrarVehiculoUI extends UiFrame {
	
	private JTextField placa;
  private JTextField annoFabricacion;
  private JTextField color;
  private JTextField marca;
  private JTextField vin;
  private JTextField sede;
  private JTextField capacidad;
  private JTextField kilometraje;
  private JTextField numeroMantenimientos;
  private ArrayList<Mantenimiento> mantenimientos;
  
	public RegistrarVehiculoUI(AdminUI admin) {
		super("Registrar vehiculo", 700, 250, 400, 600);
		setDefaultCloseOperation(UiFrame.DISPOSE_ON_CLOSE);
		mantenimientos = new ArrayList<Mantenimiento>();
		initComponents(admin);
	}
	
	public void initComponents(AdminUI admin) {
		crearLabel("Placa", 20, 10, 200, 30, 25);
		placa = crearTextField(180, 15, 200, 30, 25);
		crearLabel("Año", 20, 50, 200, 30, 25);
		annoFabricacion = crearTextField(180, 55, 200, 30, 25);
		crearLabel("Color", 20, 90, 200, 30, 25);
		color = crearTextField(180, 95, 200, 30, 25);
		crearLabel("Marca", 20, 130, 200, 30, 25);
		marca = crearTextField(180, 135, 200, 30, 25);
		crearLabel("Vin", 20, 170, 200, 30, 25);
		vin = crearTextField(180, 175, 200, 30, 25);
		crearLabel("Sede", 20, 200, 210, 30, 25);
		sede = crearTextField(180, 215, 200, 30, 25);
		crearLabel("Capacidad", 20, 250, 200, 30, 25);
		capacidad = crearTextField(180, 255, 200, 30, 25);
		crearLabel("Kilometraje", 20, 290, 200, 30, 25);
		kilometraje = crearTextField(180, 295, 200, 30, 25);
		crearLabel("Cant mantenimientos", 20, 330, 300, 30, 25);
		numeroMantenimientos = crearTextField(280, 335, 100, 30, 25);
		numeroMantenimientos.setText("0");
		crearBoton("AñadirMantenimientos", 50, 390, 290, 50, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crearMantenimiento();
			}
		});
		crearBoton("Registrar", 100, 480, 200, 70, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				admin.getAdmin().annadirVehiculo(new Vehiculo(placa.getText(), annoFabricacion.getText(), color.getText(), marca.getText(), vin.getText(), sede.getText(),
						Integer.parseInt(capacidad.getText()), Integer.parseInt(kilometraje.getText()),mantenimientos));
				dispose();
			}
		});
		repaint();
	}
	
	public void crearMantenimiento() {
		int nMantes = 0;
		try {
			nMantes = Integer.parseInt(numeroMantenimientos.getText());
		}catch(Exception ex) {
			System.out.println("Debe ingresar solo números");
			return;
		}
		for(int i = 0; i<nMantes ; i++) {
			RegistrarMantenimientoUI actual = new RegistrarMantenimientoUI(this);
		}
	}
	
	public void annadirMantenimiento(Mantenimiento pMantenimiento) {
		mantenimientos.add(pMantenimiento);
	}

}