package co.com.samtel.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ListenProperties {

	private static Properties prop = null;
	private int year;
	private int horasLaboradas;
	private int horaEntrada;
	private int minutosEntrada;
	private int horaExtra;
	private int minutosExtra;
	private String rutaFiles;
	private String nameFolder;

	public ListenProperties() {
		
	}

	public static Properties getProperties() {

		try {
			prop = new Properties();
			prop.load(new FileReader("src/co/com/samtel/properties/config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}

	public int getYear() {
		this.year = Integer.parseInt(getProperties().getProperty("year"));
		return year;
	}

	public int getHorasLaboradas() {
		this.horasLaboradas = Integer.parseInt(getProperties().getProperty("horasLaboradas"));
		return horasLaboradas;
	}

	public int getHoraEntrada() {
		this.horaEntrada = Integer.parseInt(getProperties().getProperty("horaEntrada"));
		return horaEntrada;
	}

	public int getMinutosEntrada() {
		this.minutosEntrada = Integer.parseInt(getProperties().getProperty("minutosEntrada"));
		return minutosEntrada;
	}

	public int getHoraExtra() {
		this.horaExtra  = Integer.parseInt(getProperties().getProperty("horaExtra"));
		return horaExtra;
	}

	public int getMinutosExtra() {
		this.minutosExtra  = Integer.parseInt(getProperties().getProperty("minutosExtra"));
		return minutosExtra;
	}

	public String getRutaFiles() {
		this.rutaFiles  = getProperties().getProperty("rutaFiles");
		return rutaFiles;
	}

	public String getNameFolder() {
		this.nameFolder  = getProperties().getProperty("nameFolder");
		return nameFolder;
	}
	
	

	
}
