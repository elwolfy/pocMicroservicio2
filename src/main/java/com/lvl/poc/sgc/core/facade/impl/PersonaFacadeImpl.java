package com.lvl.poc.sgc.core.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lvl.poc.core.facade.FacadeBase;
import com.lvl.poc.core.logger.CoreLogger;
import com.lvl.poc.core.logger.LoggerFactory;
import com.lvl.poc.domain.core.Persona;
import com.lvl.poc.model.BaseOperacionResponse;
import com.lvl.poc.model.CollectionResponse;
import com.lvl.poc.model.core.PersonaFiltroRequest;
import com.lvl.poc.model.core.PersonaRequest;
import com.lvl.poc.model.core.PersonaResponse;
import com.lvl.poc.sgc.core.facade.PersonaFacade;
import com.lvl.poc.sgc.core.service.PersonaService;
import com.lvl.poc.util.Constantes;
import com.lvl.poc.util.GenericUtil;

@Component
@Transactional("transactionManager")
public class PersonaFacadeImpl extends FacadeBase implements PersonaFacade{
	private CoreLogger logger = LoggerFactory.getLogger(PersonaFacadeImpl.class);

	@Autowired
	private PersonaService personaService;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CollectionResponse<PersonaResponse> find(PersonaFiltroRequest request) {
		List<PersonaResponse> collection = new ArrayList<>();
		try {
			List<Persona> listDTO = personaService.find(request);
			listDTO.stream().forEach(tt -> {
				collection.add(modelMapper.map(tt, PersonaResponse.class));
			});

		} catch (Exception e) {
			super.launchException(logger, e);
		}
		return new CollectionResponse<PersonaResponse>(collection, request.getStart(), request.getLimit(),
			request.getTotalCount());
	}

	 

	@Override
	public PersonaResponse initForm() {
		PersonaResponse response = new PersonaResponse();
		try {
			 
		} catch (Exception e) {
			launchException(logger, e);
		}
		return response;
	}

	@Override
	public BaseOperacionResponse saveOrUpdate(PersonaRequest request) {
		try {
			if(GenericUtil.isNotEmpty(request)){
				personaService.saveOrUpdate(modelMapper.map(request, Persona.class));
			}
		} catch (Exception e) {
			launchException(logger, e);
		}
		return new BaseOperacionResponse(Constantes.MessageCodigo.OK, Constantes.Message.SAVE);
	}

	 
	@Override
	public BaseOperacionResponse delete(BigDecimal personaId) {
		try{
		Persona persona = personaService.get(personaId);
			if (GenericUtil.isNotEmpty(persona)) {
				personaService.delete(persona);
			}

		} catch (Exception e) {
			launchException(logger, e);
		}
		return new BaseOperacionResponse(Constantes.MessageCodigo.OK, Constantes.Message.DELETE);
	}

	@Override
	public PersonaResponse get(BigDecimal personaId) {
		PersonaResponse personaResponse = null;
		try {
			Persona persona = personaService.get(personaId);
			if (GenericUtil.isNotEmpty(persona)) {
				personaResponse = modelMapper.map(persona, PersonaResponse.class);
			}
		} catch (Exception e) {
			launchException(logger, e);
		}
		return personaResponse;
	}

	 
}
