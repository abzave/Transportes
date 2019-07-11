package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import library.Licencia;

@SuppressWarnings("serial")
public class RegistrarLicencia extends UiFrame{

	private JTextField tipo;
  private JTextField fechaEmision;
  private JTextField fechaExpiracion;
	
	public RegistrarLicencia(RegistrarChofer chof) {
		super("Registrar licencia", 700, 400, 400, 300);
		setDefaultCloseOperation(UiFrame.DISPOSE_ON_CLOSE);
		initComponents(chof);
	}
	
	public void initComponents(RegistrarChofer chof) {
		crearLabel("Tipo", 20, 10, 200, 30, 25);
		tipo = crearTextField(180, 15, 200, 30, 25);
		crearLabel("Fechas formato dd/mm/aaaa",20,50,400,30,25);
		crearLabel("Emisión", 20, 85, 200, 30, 25);
		fechaEmision = crearTextField(180, 90, 200, 30, 25);
		crearLabel("Expiración", 20, 125, 200, 30, 25);
		fechaExpiracion = crearTextField(180, 130, 200, 30, 25);
		crearBoton("Registrar", 100, 170, 200, 70, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chof.annadirLicencia(new Licencia(tipo.getText(), fechaEmision.getText(), fechaExpiracion.getText()));
				dispose();
			}
		});
		repaint();
	}
}
