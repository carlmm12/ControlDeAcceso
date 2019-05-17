package co.com.samtel.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.SqlResultSetMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.samtel.dto.ControlDiarioDto;
import co.com.samtel.entities.CodigoUsuario;
import co.com.samtel.entities.ControlAcceso;
import co.com.samtel.entities.ControlAccesosOrd;
import co.com.samtel.repository.IcontrolAcessoOrd;
import co.com.samtel.service.IServiceControlAccesoOrd;

@Service("ControlAccesoOrdBean")
public class ControlAccesoOrdImpl implements IServiceControlAccesoOrd {

	@Autowired
	public IcontrolAcessoOrd controlAccesoOrd;

	@Override
	public void save(ControlAccesosOrd entity) {
		// TODO Auto-generated method stub

		try {
			System.out.println(entity.getId().getFecha() + "-" + entity.getTblcodigoUsuario().getCodigo());
			List<ControlAccesosOrd> controlOrd = controlAccesoOrd.findAllControlAcc(entity.getId().getFecha(),
					entity.getTblcodigoUsuario().getCodigo());

			if (controlOrd == null || controlOrd.size() == 0) {

				controlAccesoOrd.save(entity);

			} else {

				System.out.println("Ya fue insertado el registro");
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error al registrar");
		}

	}

	@Override
	public Boolean saveAll(List<ControlAccesosOrd> list) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ControlAccesosOrd> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ControlAccesosOrd> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return controlAccesoOrd.count();
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(ControlAccesosOrd entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public int countOrd() {
		// TODO Auto-generated method stub
		return controlAccesoOrd.countOrd();
	}

	@Override
	public void saveImpar(ControlAccesosOrd entity) {

		try {
			System.out.println(entity.getId().getFecha() + "-" + entity.getTblcodigoUsuario().getCodigo());
			List<ControlAccesosOrd> controlOrd = controlAccesoOrd.findAllControlAcc(entity.getId().getFecha(),
					entity.getTblcodigoUsuario().getCodigo());

			System.out.println(controlOrd.size());

			if (controlOrd.size() < 2) {

				controlAccesoOrd.save(entity);

			} else {

				System.out.println("REGISTRO IMPAR YA REGISTRADO");
			}

		} catch (Exception e) {
			System.out.println("Error al registrar");
		}

	}

	@Override
	public List<String> countDate() {
		// TODO Auto-generated method stub
		return controlAccesoOrd.countDate();
	}

	@Override
	public List<Integer> usersDate(String fecha) {
		// TODO Auto-generated method stub
		return controlAccesoOrd.usersDate(fecha);
	}

	@Override
	public List<ControlAccesosOrd> registroUsers(String fecha, int codigo) {
		// TODO Auto-generated method stub
		return controlAccesoOrd.registroUsers(fecha, codigo);
	}

	public Time getTimepo(Time tm) {

		Time tiempo = null;
		Time res = tm;

		if (res.getHours() < 1) {
			tiempo = tm;
			System.out.println("ESTE TIENE UN VALOR MENOR QUE  0" + tiempo);
		} else {

			int h = res.getHours() - 1;
			int m = res.getMinutes();
			int s = res.getSeconds();
			LocalTime timeConv = LocalTime.of(h, m, s);
			Time tt = Time.valueOf(timeConv);
			tiempo = tt;

			System.out.println("ESTE TIENE UN VALOR MAYOR - ORIGINAL = " + res + "- RESULTADO = " + tiempo);
		}

		return tiempo;
	}

	@Override
	public ControlDiarioDto controlDia(String fecha, int codigo) {

		System.out.println("la fecha y el usuario es: " + fecha + "---" + codigo);
		List<Object[]> obj = (List<Object[]>) controlAccesoOrd.controlDia(fecha, codigo);
		ControlDiarioDto controlD = null;

		for (Object[] ob : obj) {

			Time tiempo = getTimepo((Time) ob[2]);

			controlD = new ControlDiarioDto((Time) ob[0], (Time) ob[1], tiempo);

		}

		return controlD;
	}
}
