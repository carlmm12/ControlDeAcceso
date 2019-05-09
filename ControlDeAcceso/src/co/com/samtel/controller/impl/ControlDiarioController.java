package co.com.samtel.controller.impl;

import co.com.samtel.controller.IControlDiarioController;
import co.com.samtel.service.IServiceControlAccesoOrd;
import co.com.samtel.service.IServiceControlDiario;
import co.com.samtel.util.BeanUtil;

public class ControlDiarioController  implements IControlDiarioController{

	
	private IServiceControlAccesoOrd conAccDiarService;
	
	@Override
	public IServiceControlDiario getControlDiarioService() {
		if (conAccDiarService == null) {
			conAccDiarService = (IServiceControlAccesoOrd) BeanUtil.getBeanName("ControlAccesoBean");
		}
		return null;
	}
	
	

}
