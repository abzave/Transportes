package ui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class GraficoCircular{

	  private String titulo;
	  private ArrayList<Comparable> datos = new ArrayList<Comparable>();
	  private ArrayList<Integer> proporcion = new ArrayList<Integer>();
	  private int ancho;
	  private int alto;
		
	  public GraficoCircular(String titulo, int ancho, int alto) {
	    setTitulo(titulo);
	    this.alto = alto;
	    this.ancho = ancho;
	  }
	  
	  public void crear() {
		DefaultPieDataset dataset = crearDataSet();
	    JFreeChart grafico = ChartFactory.createPieChart(titulo, dataset, true, true, true);
	    ChartFrame panel = new ChartFrame(titulo, grafico);
	    panel.pack();
	    panel.setVisible(true);
	    panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  }
	  
	  public void setTitulo(String titulo) {
	    this.titulo = titulo;
	  }
	  
	  public String setTitulo() {
	    return titulo;
	  }

	  public void setDatos(Comparable dato) {
		datos.add(dato);
	  }
	  
	  public void setDatos(ArrayList<Comparable> datos) {
	    this.datos = datos;
	  }
	  
	  public void setProporcion(Integer dato) {
		proporcion.add(dato);
	  }

	  public void setProporcion(ArrayList<Integer> datosY) {
	    this.proporcion = datosY;
	  }
	  
	  public ArrayList<Comparable> getDatos(){
	    return datos;
	  }

	  public ArrayList<Integer> getProporcion(){
	    return proporcion;
	  }
	  
	  private DefaultPieDataset crearDataSet() {
		  DefaultPieDataset dataset = new DefaultPieDataset();
		  for(int i = 0; i < datos.size(); i++) {
	        dataset.setValue(datos.get(i), proporcion.get(i));
		  }
		  return dataset;
	  }

}
