package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import com.orsoncharts.util.json.JSONObject;

import aplicacion.AplTransportes;
import library.Licencia;
import personal.Chofer;
import util.ObjectToJsonParser;

@SuppressWarnings("serial")
public class RegistrarChofer extends UiFrame{

	private JTextField nombre;
  private JTextField cedula;
  private JTextField telefono;
  private JTextField correo;
  private JTextField cantLicencias;
  private ArrayList<Licencia> licencias;
	
	public RegistrarChofer() {
		super("Registrar chofer", 700, 300, 400, 380);
		licencias = new ArrayList<Licencia>();
		setDefaultCloseOperation(UiFrame.DISPOSE_ON_CLOSE);
		initComponents();
	}
	
	public void initComponents() {
		crearLabel("Nombre", 20, 10, 200, 30, 25);
		nombre = crearTextField(180, 15, 200, 30, 25);
		crearLabel("Cedula", 20, 50, 200, 30, 25);
		cedula = crearTextField(180, 55, 200, 30, 25);
		crearLabel("Telefono", 20, 90, 200, 30, 25);
		telefono = crearTextField(180, 95, 200, 30, 25);
		crearLabel("Correo", 20, 130, 200, 30, 25);
		correo = crearTextField(180, 135, 200, 30, 25);
		crearLabel("Cant Licencias", 20, 170, 200, 30, 25);
		cantLicencias = crearTextField(200, 175, 100, 30, 25);
		cantLicencias.setText("0");
		crearBoton("Añadir licencias", 50, 210, 290, 50, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				crearLicencia();
			}
		});
		crearBoton("Registrar", 100, 270, 200, 70, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			  ObjectToJsonParser parser = new ObjectToJsonParser();
				Chofer chofer = new Chofer(nombre.getText(), cedula.getText(), telefono.getText(),
				    correo.getText().length()==0?"No posee correo":correo.getText(), licencias, 0);
				AplTransportes aplicacion = new AplTransportes();
				aplicacion.getChoferes().add(chofer);
				String jsonString = parser.parseChofer(chofer).toJSONString();
				parser.save("choferesDB.json", jsonString);
				dispose();
			}
		});
		repaint();
	}
	
	public void crearLicencia() {
		int nLicencias = 0;
		try {
			nLicencias = Integer.parseInt(cantLicencias.getText());
		}catch(Exception ex) {
			System.out.println("Debe ingresar solo números");
			return;
		}
		for(int i = 0; i<nLicencias ; i++) {
			RegistrarLicencia lic = new RegistrarLicencia(this);
		}
	}
	
	public void annadirLicencia(Licencia pLicencia) {
		licencias.add(pLicencia);
	}

}