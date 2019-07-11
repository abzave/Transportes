package ui;

import javax.swing.JFrame;

public class ListadosUI extends UiFrame {
	
	public ListadosUI(String pTitulo,String texto, int x, int y, int ancho, int alto,int tamannoFuente) {
		super(pTitulo, x, y, ancho, alto);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		crearListado(texto, 0, 0, ancho, alto,tamannoFuente);
	}

}
