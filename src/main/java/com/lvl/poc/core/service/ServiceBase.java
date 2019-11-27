package com.lvl.poc.core.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvl.poc.core.ErrorResponse;
import com.lvl.poc.core.exception.BusinessException;
import com.lvl.poc.core.logger.CoreLogger;
import com.lvl.poc.core.logger.LoggerFactory;
 
@Service("serviceBase")
public class ServiceBase {

	private CoreLogger logger = LoggerFactory.getLogger(ServiceBase.class);
	@Autowired
	protected ModelMapper  modelMapper; 
	
	protected ErrorResponse buildErrorGenerico(String mensajeTecnico) {
		logger.info(mensajeTecnico);
		ErrorResponse ErrorResponse = new ErrorResponse();
		ErrorResponse.setMensaje("SERVICIO:Ocurrio un problema en la aplicacion. Vuelva a interntarlo.");
		ErrorResponse.setMensajeTecnico(mensajeTecnico);
		return ErrorResponse;
	}

	/**
	 * 
	 * @param logger
	 * @param e
	 * @throws BusinessException
	 */
	protected void launchException(CoreLogger logger, Exception e) throws BusinessException {
		if (e instanceof BusinessException) {
			throw (BusinessException) e;
		} else {
			logger.error("[ERROR] :" + e.getMessage(), e);
			ErrorResponse ErrorResponse = new ErrorResponse();
			ErrorResponse.setMensajeTecnico(e.getMessage());
			ErrorResponse.setMensaje("Ocurrio un error, vuelva a intertarlo o contacte con su Administrador");
			ErrorResponse.setTrace(e);
			throw new BusinessException(ErrorResponse);
		}
	}

}
