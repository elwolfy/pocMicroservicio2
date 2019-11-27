package com.lvl.poc.sgc.core.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lvl.poc.domain.core.Persona;

public interface PersonaRepository extends JpaRepository<Persona, BigDecimal>, JpaSpecificationExecutor<Persona> {


}
