package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import library.Viaje;
import personal.Administrador;
import ui.MenuConsultarDatosUI;

@SuppressWarnings("serial")
public class AdminUI extends UiFrame implements ActionListener{

	private Administrador admin;
	private JButton botonRegistrarChofer;
	private JButton botonRegistrarVehiculo;
	private JButton botonListarViajes;
	private JButton botonAprobarSolicitud;
	private JButton botonRegistrar;
	private JButton botonConsultar;
	
	public AdminUI(Administrador admin) {
		super("Administrador", 400, 200, 550, 625);
		this.admin = admin;
		initComponents();
	}
	
	private void initComponents() {
	  crearLabel("Unidad de Transportes del Tecnológico de Costa Rica", 10, 10, 575, 25, 22);
      botonRegistrarChofer = crearBoton("Registrar un nuevo chofer", 115, 50, 325, 75, 22);
      botonRegistrarVehiculo = crearBoton("Registrar un nuevo vehículo", 115, 140, 325, 75, 22);
      botonListarViajes = crearBoton("Listar viajes", 115, 230, 325, 75, 22);
      botonAprobarSolicitud = crearBoton("Aprobar solicitud de viaje", 115, 320, 325, 75, 22);
      botonRegistrar = crearBoton("Registrar nuevo usuario", 115, 410, 325, 75, 22);
      botonConsultar = crearBoton("Consultar datos", 115, 500, 325, 75, 22);
      botonListarViajes.addActionListener(this);
      botonAprobarSolicitud.addActionListener(this);
      botonRegistrar.addActionListener(this);
      botonRegistrarVehiculo.addActionListener(this);
      botonListarViajes.addActionListener(this);
      botonConsultar.addActionListener(this);
      botonRegistrarChofer.addActionListener(this);
      addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent evt) {
          admin.getAplicacion().guardar();
        }
       });
      repaint();
	}

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("Registrar nuevo usuario")) {
      RegistrarUsuarioUI ui = new RegistrarUsuarioUI(admin);
    }else if(e.getActionCommand().equals("Registrar un nuevo vehículo")) {
    	RegistrarVehiculoUI ui = new RegistrarVehiculoUI(this);
    }else if(e.getActionCommand().equals("Consultar datos")) {
    	MenuConsultarDatosUI ui = new MenuConsultarDatosUI();
    }else if(e.getActionCommand().equals("Registrar un nuevo chofer")) {
    	RegistrarChofer ui = new RegistrarChofer();
    }else if(e.getActionCommand().equals("Listar viajes")) {
    	listarViajes();
    }else if(e.getActionCommand().equals("Aprobar solicitud de viaje")) {
    	AprobarViajeUI ui = new AprobarViajeUI(admin.getAplicacion().getViajes(), admin.getAplicacion().getChoferes(), admin.getAplicacion().getVehiculos());
    }
  }
  
  public Administrador getAdmin() {
  	return admin;
  }
  
  public void listarViajes() {
  	String lista = "Consecutivo\tFecha\tEstado\t\tDestino\t\t\t\tDepartamento\n";
  	for(Viaje viaje: admin.getAplicacion().getViajes()) {
  		lista += viaje.getConsecutivo()+"\t"+viaje.getFechaIngreso()+"\t"+viaje.getEstado()+"\t\t"+viaje.getDestino().tabString()+"\t"+viaje.getDepartamento()+"\n";
  	}
  	ListadosUI ui = new ListadosUI("Viajes", lista, 400, 200, 1080, 720, 15);
  }

}