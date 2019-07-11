package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UiIngresar extends UiFrame implements ActionListener{
	
  private JButton botonIngresar;
  private JTextField usuario;
  private JPasswordField contrasenia;
  private boolean botonPrecionado = false;
  private String textoUsuario;
  private char[] textoContrasenia;
  private JLabel error;
  
  public UiIngresar() {
    super("Sistema autom�viles TEC", 600, 400, 600, 400);
    initComponents();
  }
	
  public void initComponents() {
    crearLabel("Sistema autom�viles TEC",150,0,300,40,25);
  	crearLabel("Usuario", 40, 75, 100, 40, 25);
  	crearLabel("Contrase�a", 20, 175, 150, 40, 25);
  	error = crearLabel("", 10, 340, 250, 15, 12);
    usuario = crearTextField(200, 75, 300, 50, 25);
    contrasenia = crearPasswordField(200, 175, 300, 50, 25);
    botonIngresar = crearBoton("Ingresar", 200, 250, 200, 75, 25);
    botonIngresar.addActionListener(this);
  	repaint();
  }
	
  public void actionPerformed(ActionEvent e) {
    setTextoContrasenia(contrasenia.getPassword());
    setTextoUsuario(usuario.getText());
    botonPrecionado = true;
  }
  
  public void setTextoUsuario(String textoUsuario) {
    this.textoUsuario = textoUsuario;
  }
  
  public String getTextoUsuario() {
    return textoUsuario;
  }
  
  public void setTextoContrasenia(char[] textoContrasenia) {
    this.textoContrasenia = textoContrasenia;
  }

  public String getTextoContrasenia() {
	String texto = String.copyValueOf(textoContrasenia);
    return texto;
  }
  
  public boolean botonPresionado() {
    return botonPrecionado;
  }
  
  public void setBotonPresionado(boolean estado) {
    botonPrecionado = estado;
  }
  
  public void setError() {
	error.setForeground(Color.red);
    error.setText("Nombre de usuario o contrase�a no validos.");
  }
	
}
