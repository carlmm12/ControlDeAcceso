package co.com.samtel.controller;

import co.com.samtel.entities.ControlAcceso;
import co.com.samtel.service.IServiceControlAcceso;

public interface IControlAccessoController {
	
	IServiceControlAcceso getControlAccesoService();
    Boolean CSVReader(String name_file);
    void create(ControlAcceso entity);
    
}
