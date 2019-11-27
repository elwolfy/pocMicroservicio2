package com.lvl.poc.core.logger;

import org.slf4j.Logger;
import org.slf4j.MDC;

public class CoreLoggerImpl<T> implements CoreLogger {

	private Logger wrappedLogger;
	@SuppressWarnings("unused")
	private Class<T> className;
	
	public CoreLoggerImpl(Class<T> _class) {
		wrappedLogger = org.slf4j.LoggerFactory.getLogger(_class);
		className = _class;
	}
	
	@Override
	public void error(Exception exception) {
		setMDC();
		wrappedLogger.error(exception.getMessage(),exception);
		MDC.clear();

	}

	@Override
	public void error(String mensaje) {
		setMDC();
		wrappedLogger.error(mensaje);
		MDC.clear();
	}

	@Override
	public void error(String mensaje, Exception exception) {
		setMDC();
		wrappedLogger.error(mensaje, exception);
		MDC.clear();
	}

	@Override
	public void info(String mensaje) {
		setMDC();
		wrappedLogger.info(mensaje);
		MDC.clear();
	}

	@Override
	public void debug(String mensaje) {
		setMDC();
		wrappedLogger.debug(mensaje);
		MDC.clear();
	}

	@Override
	public boolean isDebugEnabled() {
		return false;
	}

	private static void setMDC() {
		String usuario = "user";
		String uuid = "uih4asda-snbn4mn5m3n";
		MDC.put("usuario", usuario);
		MDC.put("uuid", uuid);	
	}
	
}
