package util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Fechas {
	public static int distanciaEntreFechas(String fecha1, String fecha2) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date fech1 = sdf.parse(fecha1);
			Date fech2 = sdf.parse(fecha2);
			return (int)( (fech2.getTime()-fech1.getTime() )  / (1000 * 60 * 60 * 24) );
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
	}
}
