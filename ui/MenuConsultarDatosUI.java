package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import aplicacion.AplTransportes;
import library.Viaje;
import personal.Chofer;

public class MenuConsultarDatosUI extends UiFrame implements ActionListener{
  
  private JButton botonChofer;
  private JButton botonDepartamento;
  private AplTransportes aplicacion = new AplTransportes();
  
  public MenuConsultarDatosUI() {
    super("Consultar datos", 450, 200, 500, 225);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    initComponents();
  }
  
  public void initComponents() {
    botonChofer = crearBoton("Top 5 de choferes asignados", 10, 10, 475, 75, 25);
    botonDepartamento = crearBoton("Top 5 departamentos/escuelas", 10, 105, 475, 75, 25);
    botonChofer.addActionListener(this);
    botonDepartamento.addActionListener(this);
    repaint();
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("Top 5 de choferes asignados")) {
      GraficoBarras grafico = new GraficoBarras("Top 5 de choferes asignados", 854, 480);
      aplicacion.choferesSort();
      ArrayList<Chofer> choferes = aplicacion.getChoferes();
      for(int i = 0; (i < 5 || i < choferes.size()); i++) {
        grafico.setDatosX(choferes.get(i).getNombre());
        grafico.setDatosY(choferes.get(i).getCantViajes());
      }
      grafico.crear("Choferes", "Cantidad de viajes");
    }else if(e.getActionCommand().equals("Top 5 departamentos/escuelas")) {
    	GraficoCircular grafico = new GraficoCircular("Top 5 de departamentos", 854, 480);
        aplicacion.viajesSort();
        ArrayList<Viaje> viajes = aplicacion.getViajes();
        for(int i = 0; (i < 5 && i < viajes.size()); i++) {
          grafico.setDatos(viajes.get(i).getDepartamento().getNombre());
          grafico.setProporcion(viajes.get(i).getDepartamento().getCantViajes());
        }
        grafico.crear();

    }
  }

}
