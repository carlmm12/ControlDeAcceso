package co.com.samtel.controller.impl;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.samtel.controller.IControlAccesoOrdController;
import co.com.samtel.entities.CodigoUsuario;
import co.com.samtel.entities.ControlAcceso;
import co.com.samtel.entities.ControlAccesosOrd;
import co.com.samtel.service.IServiceCodigoUsuario;
import co.com.samtel.service.IServiceControlAcceso;
import co.com.samtel.service.IServiceControlAccesoOrd;
import co.com.samtel.util.BeanUtil;

public class ControlAccesoOrdController implements IControlAccesoOrdController {

	private IServiceControlAccesoOrd conAccOrdService;
	private IServiceControlAcceso conAccService;
	private IServiceCodigoUsuario codUserService;
	private List<ControlAcceso> accesos;
	private CodigoUsuario usuarioCod;
	private ControlAccesosOrd codigoAccessOrd;
	private int countAc = 0;

	/*
	 * Este metodo me permite generar usar el servicio de codigoUsuario.
	 */

	@Override
	public IServiceCodigoUsuario getCodigoUsuarioService() {
		if (codUserService == null) {
			codUserService = (IServiceCodigoUsuario) BeanUtil.getBeanName("codigoUsuarioBean");
		}
		return codUserService;
	}

	/*
	 * Este metodo me permite generar usar el servicio de controlAccesoOrd.
	 */

	
	@Override
	public IServiceControlAccesoOrd getControlAccesoOrdService() {
		if (conAccOrdService == null) {
			conAccOrdService = (IServiceControlAccesoOrd) BeanUtil.getBeanName("ControlAccesoOrdBean");
		}
		return conAccOrdService;
	}

	/*
	 * Este metodo me permite generar usar el servicio de controlAcceso.
	 */
	@Override
	public IServiceControlAcceso getControlAccesoService() {
		if (conAccService == null) {
			conAccService = (IServiceControlAcceso) BeanUtil.getBeanName("ControlAccesoBean");
		}

		return conAccService;
	}

	/*
	 * Metodo que me traera de la tabal control de acceso todos los registros, los
	 * ordenara y los registrara agregando el tipo de acceso
	 */

	/*
	 * metodo para obtener los registros del control de accesos ordenados
	 */
	public int getcountAc() {
		// conteo de los registros ordenados
		
		return getControlAccesoOrdService().countOrd() + 1;
	}
	
	@Override
	public void register(int month) {
		int cont = 0;

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// llamado al metodo que me trae el rando de fechas por el cual solo se hizo el
		// registro

		List<String> fechas = getControlAccesoService().countDate();
		for (String fechaDia : fechas) {

			// llamado al metodo que me trae los codigos de los usuario que se registraron
			// el la fecha del ciclo.

			List<Integer> codigos = getControlAccesoService().usersDate(fechaDia);
			System.out.println("--------------------------------");
			System.out.println("dia: " + fechaDia);

			for (Integer codigo : codigos) {
				cont = 0;

				// llamado al usuario de acuerdo a lo registros del control de acceso por fecha
				// especificada

				this.usuarioCod = getCodigoUsuarioService().findByCode(codigo);

				System.out.println(usuarioCod.toString());

				// llamado al metodo que me trae la lista de los registros por usuario de
				// acuerdo a la fecha especificada

				List<ControlAcceso> controlesDiarios = getControlAccesoService().registroUsers(fechaDia, codigo);

				System.out.println("registros del usuario" + codigo + "de la fecha" + fechaDia);
				
				// metodo que me configura el tipo de acceso de acuerdo a la cantidad de registros
				for (ControlAcceso controlesDiario : controlesDiarios) {

					cont++;
					if (cont % 2 == 0) {
						
						
						
						
						System.out.println(controlesDiario.toString() + "par (salida)");
						codigoAccessOrd = new ControlAccesosOrd(getControlAccesoOrdService().countOrd() + 1,
								controlesDiario.getId().getDatetime(), 6, usuarioCod);
						System.out.println(this.codigoAccessOrd.toString());
						getControlAccesoOrdService().save(codigoAccessOrd);

					} else {

						System.out.println(controlesDiario.toString() + "impar (entrada)");
						codigoAccessOrd = new ControlAccesosOrd(getControlAccesoOrdService().countOrd() + 1,
								controlesDiario.getId().getDatetime(), 5, usuarioCod);
						System.out.println(this.codigoAccessOrd.toString());
						getControlAccesoOrdService().save(codigoAccessOrd);
					}

				}

				
				//valida de los registros terminas en par o impar y de ser impar crea un nuevo controlAccesoOrd
				
				if (cont % 2 == 0) {

					System.out.println("termino par" + "par");
				} else {

					System.out.println("termino impar" + "impar");
					this.codigoAccessOrd.setId(getControlAccesoOrdService().countOrd() + 1);
					this.codigoAccessOrd.setTipoAcceso(6);
					System.out.println(this.codigoAccessOrd.toString());
					System.out.println("termino el ciclo de los registros del usuario");
					getControlAccesoOrdService().save(codigoAccessOrd);
				}

			}

			System.out.println("--------------------------------");

		}

	}

}
