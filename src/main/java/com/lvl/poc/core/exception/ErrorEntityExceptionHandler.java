package com.lvl.poc.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lvl.poc.util.Constantes;
import com.lvl.poc.util.GenericUtil;
 

@ControllerAdvice
@RestController
public class ErrorEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getMessage(), "Error no controlado");
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@ExceptionHandler(BusinessException.class)
	public final ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException ex, WebRequest request) {
		 if(GenericUtil.isNotEmpty(ex.getListError())) {
			 ExceptionResponse exceptionResponse=new ExceptionResponse(Constantes.MessageCodigo.TX, ex.getListError().get(0).getMensaje());
			 return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		 }else {
			 ExceptionResponse exceptionResponse=new ExceptionResponse(Constantes.MessageCodigo.TX, "Error no Controlado");
			 return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	

}
