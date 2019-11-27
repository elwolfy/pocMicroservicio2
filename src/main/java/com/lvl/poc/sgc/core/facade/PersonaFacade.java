package com.lvl.poc.sgc.core.facade;

import java.math.BigDecimal;

import com.lvl.poc.model.BaseOperacionResponse;
import com.lvl.poc.model.CollectionResponse;
import com.lvl.poc.model.core.PersonaFiltroRequest;
import com.lvl.poc.model.core.PersonaRequest;
import com.lvl.poc.model.core.PersonaResponse;

public interface PersonaFacade {
	PersonaResponse initForm();

	CollectionResponse<PersonaResponse> find(PersonaFiltroRequest request);

	BaseOperacionResponse saveOrUpdate(PersonaRequest request);

	BaseOperacionResponse delete(BigDecimal idPersona);

	PersonaResponse get(BigDecimal personaId);
}
