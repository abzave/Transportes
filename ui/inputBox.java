package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class inputBox extends UiFrame{
	/*para usarlo implemente este codigo para esperar la ventana y recibir su valor
	inputBox input = new InputBox(titulo, pregunta);
	while(true){
		Thread.sleep(1);
		if(input.isFinalizado()){
			String texto = input.getTexto();
			input.dispose();
		}
	}
	*/
	
	private JTextField campoTexto;
	private boolean finalizado;
	
	public inputBox(String pTitulo,String pPregunta) {
		super(pTitulo, 600, 400, 800, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponents(pPregunta);
	}

	private void initComponents(String pregunta) {
		crearLabel(pregunta, 400-pregunta.length()*7, 20, 800, 30, 25);
		campoTexto = crearTextField(20, 100, 760, 50, 25);
		crearBoton("Aceptar", 150, 200, 200, 100, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finalizado = true;
			}
		});;
		crearBoton("Cancelar", 450, 200, 200, 100, 25).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				finalizado = true;
			}
		});;
		repaint();
	}
	
	public String getTexto() {
		return campoTexto.getText();
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}
	
}
