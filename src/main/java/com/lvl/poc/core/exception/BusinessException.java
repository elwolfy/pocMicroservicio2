package com.lvl.poc.core.exception;

import com.lvl.poc.core.ErrorResponse;

 
public class BusinessException extends CoreException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1826670162102422903L;
	
 

	public BusinessException() {
		super();
	}
	
	public BusinessException(ErrorResponse ErrorResponse) {
		super(ErrorResponse);
	}
	
	public BusinessException(String codError){
		 
			ErrorResponse ErrorResponse = new ErrorResponse();
			ErrorResponse.setCodigo("0000");
			ErrorResponse.setMensaje("Ocurrio un error no identificado, informe a soporte.");
		 
		super.listError.add(ErrorResponse);
	}

}
