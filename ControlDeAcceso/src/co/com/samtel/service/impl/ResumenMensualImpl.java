package co.com.samtel.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.samtel.entities.ResumenMensual;
import co.com.samtel.repository.IResumenMensual;
import co.com.samtel.service.IServiceResumenMensual;

@Service("ResumenMensualBean")
public class ResumenMensualImpl implements IServiceResumenMensual {

	@Autowired
	IResumenMensual rmen;

	@Override
	public void save(ResumenMensual entity) {
		try {
			rmen.save(entity);
		} catch (Exception e) {
			System.out.println("No se pudo registrar la entidad");
		}

	}

	@Override
	public Boolean saveAll(List<ResumenMensual> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ResumenMensual> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ResumenMensual> findAll() {
		// TODO Auto-generated method stub
		return rmen.findAll();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ResumenMensual entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer findnumAlertas(int codigo, int mes, int year, int tipoAlerta) {
		Integer dato = rmen.findnumAlertas(codigo, mes, year , tipoAlerta);
       System.out.println("ESTO ES LO QUE TRAE LA CONSULTA" + dato);
		if (dato == null || dato == 0) {
			dato = 0;
		}

		return dato;
	}

	@Override
	public void updateEntity(ResumenMensual entity) {
		
		String mes =  entity.getFecha().toLocaleString();
		System.out.println(mes);
		System.out.println("esto trae la consulta por el mes " + mes);
		try {
			rmen.updateEntity(entity.getNroAlertas(), entity.getPorcentajeAlertas(), entity.getId().getCodigo(), 4, entity.getId().getTipoAlerta() );
			
		} catch (Exception e) {
			System.out.println("No se pudo  actualizar los datos");
		}
		
	}

	@Override
	public void deleteRegistros(int mes, int year) {
		try {
			rmen.deleteRegistros(mes, year);
		} catch (Exception e) {
			System.out.println("Error al intenta eliminar los registros con el año:" + year + " y el mes: " + mes);
		}
		
	}

	@Override
	public List<ResumenMensual> findbyAlertType(int tipoAlerta) {
		
		return rmen.findbyAlertType(tipoAlerta);
	}



}
