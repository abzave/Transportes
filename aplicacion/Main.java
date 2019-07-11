package aplicacion;

import personal.Administrador;
import personal.Secretaria;
import ui.AdminUI;
import ui.SecretariaUI;
import ui.UiIngresar;

public class Main {

  private static boolean noPudoIngresar = false;
	
  public static void main(String[] args) {
  	AplTransportes aplicacion = new AplTransportes();
  	aplicacion.choferesSort();
  	UiIngresar login = new UiIngresar();
  	do {
  		if(noPudoIngresar) {
  	      login.setError();
  		}
  		noPudoIngresar = true;
  		login.setBotonPresionado(false);
  	    while(!login.botonPresionado()) {
  	      try {
  		    Thread.sleep(1);
  		  } catch (InterruptedException e) {
  		    e.printStackTrace();
  		  }
  	    }
  	}while(!aplicacion.puedeIngresar(login.getTextoUsuario(), login.getTextoContrasenia()));
  	login.dispose();
  	login = null;
  	if(aplicacion.getEsAdmin()) {
        Administrador admin = (Administrador)aplicacion.getUsuario();
        admin.setAplicacion(aplicacion);
        AdminUI menu = new AdminUI(admin);
  	}else {
        Secretaria user = (Secretaria)aplicacion.getUsuario();
        SecretariaUI menu = new SecretariaUI(user);
      }
   }
}
