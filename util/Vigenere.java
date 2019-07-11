package util;

import java.lang.StringBuilder;

public class Vigenere {

  private String frase;
  private String codigo;
	
  public Vigenere(String frase, String codigo) {
    this.frase = frase;
    this.codigo = codigo;
  }

  public String cifrar() {
	String codigoR;
	String fraseFinal = "";
	for(int i = 0; i < frase.length(); i++) {
      codigoR = new StringBuilder(codigo).reverse().toString();
      int valorASCII = frase.charAt(i);
      valorASCII += (codigoR.charAt(0) - '0');
      fraseFinal += (char)valorASCII;
	}
	frase = fraseFinal;
    return fraseFinal; 
  }
  
  public String descifrar() {
    String codigoR;
    String fraseFinal = "";
    for(int i = 0; i < frase.length(); i++) {
      codigoR = new StringBuilder(codigo).reverse().toString();
	  int valorASCII = frase.charAt(i);
	  valorASCII -= (codigoR.charAt(0) - '0');
	  fraseFinal += (char)valorASCII;
    }
    frase = fraseFinal;
    return fraseFinal; 
  }

}
