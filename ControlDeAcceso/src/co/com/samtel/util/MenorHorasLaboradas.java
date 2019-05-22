package co.com.samtel.util;

import java.awt.Desktop;
import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import co.com.samtel.dto.ControlDiarioAlertaDto;
import co.com.samtel.entities.ResumenMensual;

public class MenorHorasLaboradas {

	public MenorHorasLaboradas() {

	}

	/*
	 * metodo que me permite traer la ruta especifica del proyecto
	 */
	public void reporteMenorHorasLaboradas(List<ControlDiarioAlertaDto> controles, List<ResumenMensual> resumenesMen) {

		try {

			// llamado al metodo que me permite generar la carpeta o verificar si se
			// encuentra disponible
			folderVerify.createDirec();

			// llamdo al metodo que me genera el nombre del archivo a y ala vez la ruta a la
			// carpeta donde se creara el reporte
			String fileName = folderVerify.createFileName("Menor_numero_Horas");

			// creacion del archivo de excel para el reporte
			Workbook book = new XSSFWorkbook();
			Sheet sheet1 = book.createSheet(" Resumen Menor numero Horas");
			Sheet sheet = book.createSheet("Menor numero Horas");

			// LLENADO DEL ARCHIVO CON EL TITULO Y CON LOS DATOS QUE ME TRAE LA BASE DE
			// DATOS.

			// Esto me permite agregarle los estilos que tomar� las celda de los titulos de
			// los reportes

			CellStyle tituloEstilo = book.createCellStyle();
			tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
			tituloEstilo.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
			Font title = book.createFont();
			title.setFontName("Calibri");
			title.setBold(true);
			title.setFontHeightInPoints((short) 11);
			tituloEstilo.setFont(title);

			// SE CREA LAS CELDAS CON EL NOMBRE ASOCIADO CON LA INFORMACI�N QUE LLEGA A
			// CONTROL DIARIO.
			// SE HACE UN CICLO PARA REGISTRAR EN UNA MISMA FILA LOS TITULOS DE LA
			// INFORMACI�N.

			
			// SE CREA EL TITULO BASE PARA LA HOJA NUMERO 1 CON EL NOMBRE DE RESUMEN RETARDOS 
			
			String[] tituloResumen = new String[] { "FECHA", "CODIGO USUARIO", "NOMBRE", "NUMERO ALERTAS", "PORCENTAJE DE ALERTAS", "TOTAL DIAS" };
			Row titulosResumen = sheet1.createRow(0);
			
			for (int i = 0; i < tituloResumen.length; i++) {
				Cell titulo = titulosResumen.createCell(i);
				titulo.setCellStyle(tituloEstilo);
				titulo.setCellValue(tituloResumen[i]);
				sheet1.autoSizeColumn(i);

			}
			
			// carga de datos en la hoja 1 (resumen retardos)
			
			int numColRes = 6;
			int countRes = 0;
			
			for (ResumenMensual resumen : resumenesMen) {
				

				countRes++;
				if (countRes <= resumenesMen.size()) {
					Row resMen = sheet1.createRow(countRes);

					for (int i = 0; i < numColRes; i++) {

						Cell cellDataRes = resMen.createCell(i);
						switch (i) {

						case 0:
							cellDataRes.setCellValue(resumen.getFecha().toString());
							
							break;
						case 1:
							cellDataRes.setCellValue( resumen.getId().getCodigo());
							
							break;
						case 2:
							cellDataRes.setCellValue(resumen.getUsuario());
							
							break;
						case 3:
							cellDataRes.setCellValue(resumen.getNroAlertas());
							
							break;
						case 4:
							cellDataRes.setCellValue(resumen.getPorcentajeAlertas());
							
							break;
						case 5:
							cellDataRes.setCellValue(resumen.getTotalDias());
							
							break;

						}
						sheet1.autoSizeColumn(i);
					}

				}
				
				
				
			} // fin del recorrido de la lista de la entidad ResumenesMensuales
			
			

			
			// SE CREA EL TITULO BASE PARA LA HOJA NUMERO 2 CON EL NOMBRE DE RETARDOS 

			String[] tituloHead = new String[] { "FECHA", "CODIGO USUARIO", "NOMBRE", "ENTRADA", "SALIDA",
					"HORAS LABORADAS", "ALERTAS HORAS TRABAJADAS" };
			Row titulos = sheet.createRow(0);

			for (int i = 0; i < tituloHead.length; i++) {
				Cell titulo = titulos.createCell(i);
				titulo.setCellStyle(tituloEstilo);
				titulo.setCellValue(tituloHead[i]);
				sheet.autoSizeColumn(i);

			}

			// Carga de los datos a el archivo excel.

			int numCol = 7;
			int count = 0;

			for (ControlDiarioAlertaDto controlD : controles) {

				count++;
				if (count <= controles.size()) {
					Row controlesD = sheet.createRow(count);

					for (int i = 0; i < numCol; i++) {

						Cell cellData = controlesD.createCell(i);
						switch (i) {

						case 0:
							cellData.setCellValue(controlD.getFecha());
							break;
						case 1:
							cellData.setCellValue(controlD.getCodigo());
							break;
						case 2:
							cellData.setCellValue(controlD.getNombre());
							break;
						case 3:
							cellData.setCellValue(controlD.getEntrada());
							break;
						case 4:
							cellData.setCellValue(controlD.getSalida());
							break;
						case 5:
							cellData.setCellValue(controlD.getTiempo());
							break;
						case 6:
							cellData.setCellValue(controlD.getAlerta());
							break;

						}

						sheet.autoSizeColumn(i);
					}

				}

			}

			FileOutputStream fileout = new FileOutputStream(new File(fileName));
			book.write(fileout);
			fileout.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
