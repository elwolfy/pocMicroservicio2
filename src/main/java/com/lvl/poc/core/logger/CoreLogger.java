package com.lvl.poc.core.logger;

public interface CoreLogger {

	/**
	 * 
	 * @param exception
	 */
	void error(Exception exception);
	
	/**
	 * 
	 * @param mensaje
	 */
	void error(String mensaje);
	
	/**
	 * 
	 * @param mensaje
	 * @param exception
	 */
	void error(String mensaje, Exception exception);
	
	/**
	 * 
	 * @param mensaje
	 */
	void info(String mensaje);
	
	/**
	 * 
	 * @param mensaje
	 */
	void debug(String mensaje);
	
	/**
	 * 
	 * @return
	 */
	boolean isDebugEnabled();
	
}
