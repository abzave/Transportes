package ui;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import aplicacion.AplTransportes;

public class GraficoBarras extends UiFrame{

  private String titulo;
  private ArrayList<Comparable> datosX = new ArrayList<Comparable>();
  private ArrayList<Integer> datosY = new ArrayList<Integer>();
  private int ancho;
  private int alto;
	
  public GraficoBarras(String titulo, int ancho, int alto) {
    super(titulo, 200, 400, ancho, alto);
    setTitulo(titulo);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.alto = alto;
    this.ancho = ancho;
  }
  
  public void crear(String nombreX, String nombreY) {
    DefaultCategoryDataset dataset = crearDataSet();
    JFreeChart grafico = ChartFactory.createBarChart(titulo, nombreX, nombreY, dataset, 
        PlotOrientation.VERTICAL, true, true, true);
    ChartPanel panel = new ChartPanel(grafico);
    panel.setPreferredSize(new Dimension(ancho, alto));
    setContentPane(panel);
  }
  
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
  
  public String setTitulo() {
    return titulo;
  }

  public void setDatosX(Comparable dato) {
    datosX.add(dato);
  }
  
  public void setDatosX(ArrayList<Comparable> datosX) {
    this.datosX = datosX;
  }
  
  public void setDatosY(Integer dato) {
    datosY.add(dato);
  }

  public void setDatosY(ArrayList<Integer> datosY) {
    this.datosY = datosY;
  }
  
  public ArrayList<Comparable> getDatosX(){
    return datosX;
  }

  public ArrayList<Integer> getDatosY(){
    return datosY;
  }
  
  private DefaultCategoryDataset crearDataSet() {
	  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	  for(int i = 0; i < datosX.size(); i++) {
        dataset.setValue(datosY.get(i), datosX.get(i), "");
	  }
	  return dataset;
  }
  
}
