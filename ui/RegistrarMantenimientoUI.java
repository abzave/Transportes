package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import library.Empresa;
import library.Mantenimiento;

@SuppressWarnings("serial")
public class RegistrarMantenimientoUI extends UiFrame {
	
  private JTextField fechaInicio;
  private JTextField monto;
  private JTextField detalle;
  private JTextField tipo;
  private Empresa empresa;
  
	public RegistrarMantenimientoUI(RegistrarVehiculoUI vehiculo) {
		super("Registrar mantenimiento", 700, 200, 600, 320);
		setDefaultCloseOperation(UiFrame.DISPOSE_ON_CLOSE);
		initComponents(vehiculo);
	}
	
	public void initComponents(RegistrarVehiculoUI vehiculo) {
		crearLabel("Tipo", 20, 10, 200, 30, 25);
		tipo = crearTextField(300, 15, 200, 30, 25);
		crearLabel("Fecha", 20, 50, 200, 30, 25);
		fechaInicio = crearTextField(300, 55, 200, 30, 25);
		crearLabel("Monto", 20, 90, 200, 30, 25);
		monto = crearTextField(300, 95, 200, 30, 25);
		crearLabel("Detalle", 20, 130, 200, 30, 25);
		detalle = crearTextField(300, 135, 200, 30, 25);
		crearBoton("Añadir Empresa", 20, 175, 250, 100, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registrarEmpresa();
			}
		});
		crearBoton("Registrar", 320, 175, 250, 100, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(new Mantenimiento(fechaInicio.getText(), Double.parseDouble(monto.getText()), detalle.getText(), tipo.getText(), empresa));
				//dispose();
			}
		});
		repaint();
	}
	
	public void registrarEmpresa() {
		RegistrarEmpresaUI emp = new RegistrarEmpresaUI(this);
	}
	
	public void setEmpresa(Empresa pEmpresa) {
		empresa = pEmpresa;
	}

}