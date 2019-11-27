package com.lvl.poc.domain.audit;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {

 

	/**
	 * 
	 */
	private static final long serialVersionUID = 6539424046273746753L;

	@Column(name = "habilitado")
	private Boolean habilitado;

	@Column(name = "creado_por")
	private BigDecimal creadoPor;

	@Column(name = "modificado_por")
	private BigDecimal modificadoPor;

	@Column(name = "creado")
	private LocalDateTime creado;

	@Column(name = "modificado")
	private LocalDateTime modificado;

	public BaseEntity() {
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public BigDecimal getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(BigDecimal creadoPor) {
		this.creadoPor = creadoPor;
	}

	public BigDecimal getModificadoPor() {
		return modificadoPor;
	}

	public void setModificadoPor(BigDecimal modificadoPor) {
		this.modificadoPor = modificadoPor;
	}

	public LocalDateTime getCreado() {
		return creado;
	}

	public void setCreado(LocalDateTime creado) {
		this.creado = creado;
	}

	public LocalDateTime getModificado() {
		return modificado;
	}

	public void setModificado(LocalDateTime modificado) {
		this.modificado = modificado;
	}

}
