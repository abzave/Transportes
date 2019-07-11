package ui;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;


@SuppressWarnings("serial")
public abstract class UiFrame extends JFrame{
	protected String returnText;
	
  public UiFrame(String pTitulo, int x, int y, int ancho, int alto) {
    setLayout(null);
    setBounds(x,y,ancho,alto);
  	setTitle(pTitulo);
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	setResizable(false);
  	setVisible(true);
  	repaint();
  }
  
	
  public JLabel crearLabel(String texto,int x, int y, int ancho, int alto,int tamannoFuente) {
    JLabel label = new JLabel(texto);
    label.setBounds(x,y,ancho,alto);
    label.setFont(new Font(null,Font.PLAIN,tamannoFuente));
    add(label);
    return label;
  }
	
  public JTextField crearTextField(int x, int y, int ancho, int alto,int tamannoFuente) {
  	JTextField textField = new JTextField();
  	textField.setBounds(x,y,ancho,alto);
  	textField.setFont(new Font(null,Font.PLAIN,tamannoFuente));
  	add(textField);
  	return textField;
  }
  
  public JButton crearBoton(String texto, int x, int y, int ancho, int alto, int tamannoFuente) {
    JButton button = new JButton(texto);
    button.setBounds(x, y, ancho, alto);
    button.setFont(new Font(null,Font.PLAIN,tamannoFuente));
    add(button);
    return button;
  }
  public JList<String> crearMultipleSeleccion(String pregunta,String[] opciones, boolean seleccionMultiple) {
		JList<String> lista = new JList<String>(opciones);
		lista.setSelectionMode(seleccionMultiple?ListSelectionModel.MULTIPLE_INTERVAL_SELECTION: ListSelectionModel.SINGLE_SELECTION);
		lista.setBounds(400,450,200,200);
		lista.setVisible(true);
		JOptionPane.showMessageDialog(this, new JScrollPane(lista), pregunta, 3);
		return lista;
  }
  
  public JTextArea crearListado(String pregunta,int x,int y,int ancho,int alto, int tamannoFuente) {
		JTextArea area = new JTextArea(pregunta);
		JScrollPane pane = new JScrollPane(area);
		pane.setBounds(x, y, ancho-10, alto-35);
		area.setFont(new Font(null,Font.PLAIN, tamannoFuente));
		add(pane);
		pane.repaint();
		area.repaint();
		return area;
  }
  
	public String getReturnText() {
		return returnText;
	}

	public void setReturnText(String pReturnText) {
		returnText = pReturnText;
	}
	
	public JPasswordField crearPasswordField(int x, int y, int ancho, int alto,int tamannoFuente) {
		JPasswordField textField = new JPasswordField();
		textField.setBounds(x,y,ancho,alto);
		textField.setFont(new Font(null,Font.PLAIN,tamannoFuente));
		add(textField);
	    return textField;
	  }
  
}