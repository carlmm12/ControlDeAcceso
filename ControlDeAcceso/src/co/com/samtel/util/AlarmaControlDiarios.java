package co.com.samtel.util;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.io.File;

public class AlarmaControlDiarios {

	public AlarmaControlDiarios() {

	}
	
	/*
	 * metodo para crear la carpeta en caso de que no exista
	 */
	
	public void createDirec() {
		// System.out.println(new File(".").getAbsolutePath());
				String desktopPath = System.getProperty("user.home") + "/Desktop";
				
				desktopPath = desktopPath.replace("\\", "/");
				File folder = new File(desktopPath + "/Reportes");
				
				if (!folder.exists()) { 
					System.out.println("Creando la carpeta");
					folder.mkdir();
					System.out.println(folder.getAbsolutePath());
				}else {
					System.out.println("No se puedo crear la carpeta por que ya existe");
				}
	}

	/*
	 * metodo que me permite traer la ruta especifica del proyecto
	 */
	public void reporteAlarma() {
       createDirec();
		
		
	}

}
