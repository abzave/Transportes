package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import personal.Administrador;

public class RegistrarUsuarioUI extends UiFrame implements ActionListener{

  private Administrador admin;
  private JTextField nombre;
  private JTextField cedula;
  private JTextField telefono;
  private JTextField departamento;
  private JTextField correo;
  private JLabel error;
  private JButton botonRegistrar;

  public RegistrarUsuarioUI(Administrador admin) {
    super("Registro de usuario", 400, 200, 500, 400);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.admin = admin;
    initComponents();
  }
  
  private void initComponents() {
    crearLabel("Registrar usuario", 160, 10, 240, 30, 24);
    crearLabel("Nombre: ", 10, 60, 90, 25,  22);
    crearLabel("Cédula: ", 10, 105, 80, 25, 22);
    crearLabel("Teléfono: ", 10, 155, 100, 25, 22);
    crearLabel("Departamento: ", 10, 205, 150, 25, 22);
    crearLabel("Correo:", 10, 255, 100, 25, 22);
    error = crearLabel("", 10, 335, 450, 25, 16);
    nombre = crearTextField(160, 60, 300, 30, 22);
    cedula = crearTextField(160, 105, 300, 30, 22);
    telefono = crearTextField(160, 155, 300, 30, 22);
    departamento = crearTextField(160, 205, 300, 30, 22);
    correo = crearTextField(160, 255, 300, 30, 22);
    botonRegistrar = crearBoton("Registrar", 160, 300, 150, 35, 22);
    botonRegistrar.addActionListener(this);
    repaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(esEntradaValida()){
      try {
      admin.registrarSecretaria(correo.getText(), nombre.getText(), cedula.getText(), 
          telefono.getText(), departamento.getText());
      JOptionPane.showMessageDialog(null, "Se le ha enviado un correo con la contraseña.", "Usuario registrado", 
          JOptionPane.INFORMATION_MESSAGE);
      }catch(Exception e1) {
        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
      }
      this.dispose();
    }
  }
  
  private boolean hayCamposVacios() {
    if(nombre.getText().equals("") || cedula.getText().equals("") || telefono.getText().equals("") || 
        departamento.getText().equals("") || correo.getText().equals("")) {
      return true;
    }else {
      return false;
    }
  }
  
  private boolean esNumerico(String valor) {
    try {
      Integer.parseInt(valor);
      return true;
    }catch(Exception e) {
      return false;
    }
  }
  
  private boolean esEntradaValida() {
    if(!hayCamposVacios()) {
       if(esNumerico(cedula.getText())){
         if(esNumerico(telefono.getText())) {
            return true;
         }else {
           marcarError("El teléfono deber ser númerica y sin guiones");
           return false;
         }
       }else {
    	 marcarError("La cédula deber ser númerica y sin guiones");
         return false;
       }
    }else {
    	marcarError("No puede haber campos vacíos.");
    	return false;
    }
  }
  
  private void marcarError(String texto) {
    error.setForeground(Color.red);
    error.setText(texto);
  }

}
