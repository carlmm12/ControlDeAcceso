package co.com.samtel.controller.impl;

import co.com.samtel.controller.IControlAccesoOrdController;
import co.com.samtel.service.IServiceControlAcceso;
import co.com.samtel.service.IServiceControlAccesoOrd;
import co.com.samtel.util.BeanUtil;

public class ControlAccesoOrdController implements IControlAccesoOrdController {

	private IServiceControlAccesoOrd conAccOrdService;
	
	@Override
	public IServiceControlAccesoOrd getControlAccesoOrdService() {
		if (conAccOrdService == null) {
			conAccOrdService = (IServiceControlAccesoOrd) BeanUtil.getBeanName("ControlAccesoBean");
		}
		return null;
	}

}
