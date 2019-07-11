package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import aplicacion.AplTransportes;
import personal.Secretaria;

@SuppressWarnings("serial")
public class SecretariaUI extends UiFrame{
	private Secretaria secretaria;

	public SecretariaUI(Secretaria pSecretaria) {
		super("Adiminstracion secretarial", 750, 300, 300, 500);
		secretaria = pSecretaria;
		initComponents();
	}
	public void initComponents() {
		crearBoton("Registrar Pasajero", 20, 20, 250, 100, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrarPasajeroUI registrar = new RegistrarPasajeroUI(secretaria);
			}
		});
		crearBoton("Solicitar viaje", 20, 150, 250, 100, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SolicitarViajeUI solicitud = new SolicitarViajeUI("Solicitar Viaje", secretaria);
			}
		});;
		crearBoton("Viajes", 20, 280, 250, 100, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				filtrar();
			}
		});
		addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) {
        secretaria.getAplicacion().guardar();
      }
     });
		repaint();
	}
	
	public void filtrar() {
		FIltradoUI filtro = new FIltradoUI(secretaria.getViajes());
	}
	

}