package co.com.samtel.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class folderVerify {
	


/*
 * metodo para crear la carpeta en caso de que no exista
 */

public static void createDirec() {
	// System.out.println(new File(".").getAbsolutePath());
	String desktopPath = System.getProperty("user.home") + "/Desktop";

	desktopPath = desktopPath.replace("\\", "/");
	File folder = new File(desktopPath + "/Reportes");

	if (!folder.exists()) {
		System.out.println("Creando la carpeta");
		folder.mkdir();
		System.out.println(folder.getAbsolutePath());
	} else {
		System.out.println("No se pudo crear la carpeta por que ya existe");
	}
}

/*
 * METODO QUE ME GENERA EL NOMBRE DEL ARCHIVO EXCEL CON LA FECHA DE ACTUAL Y
 * DEVUELVA UN STRING CON EL NOMBRE DE LA RUTA Y EL NOMBRE DEL ARCHIVO
 */

public  static String createFileName(String nombre) {
	Date date = new Date();
	DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
	String convertido = fecha.format(date);
	System.out.println(convertido);

	String nameFile = "ControlAcceso_" + nombre + "_" + convertido + ".xlsx";
	String rute = System.getProperty("user.home") + "/Desktop/Reportes/";
	rute = rute.replace("\\", "/");
	String foldR = rute + nameFile;
	System.out.println(rute);
	System.out.println(foldR);
	return foldR;
}


}
