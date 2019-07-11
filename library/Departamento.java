package library;

public class Departamento{

  private String nombre;
  private int cantViajes = 0;
  
  public Departamento(String nombre) {
    setNombre(nombre);
  }
  
  public Departamento(String nombre, int cantViajes) {
    setNombre(nombre);
    setCantViajes(cantViajes);
  }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public String getNombre() {
    return nombre;
  }
  
  public void setCantViajes(int cantViajes) {
    this.cantViajes = cantViajes;
  }
  
  public int getCantViajes() {
    return cantViajes;
  }
  @Override
  public String toString() {
  	return "Nombre: "+nombre;
  }
}