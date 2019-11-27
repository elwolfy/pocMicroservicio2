package com.lvl.poc.core.exception;

import java.util.ArrayList;
import java.util.List;

import com.lvl.poc.core.ErrorResponse;
import com.lvl.poc.core.logger.CoreLogger;
 
 
public class CoreException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2958771822623649398L;

	protected List<ErrorResponse> listError = new ArrayList<>();

	public CoreException() {
	}

	public CoreException(ErrorResponse ErrorResponse) {
		listError.add(ErrorResponse);
	}

	public CoreException(CoreLogger logger, Exception e) {
		logger.error(e.getMessage(), e);
		ErrorResponse ErrorResponse = new ErrorResponse();
		ErrorResponse.setMensajeTecnico(e.getMessage());
		ErrorResponse.setTrace(e);
		ErrorResponse.setMensaje("");
		listError.add(ErrorResponse);
	}

	/**
	 * @return the listError
	 */
	public List<ErrorResponse> getListError() {
		return listError;
	}

}
