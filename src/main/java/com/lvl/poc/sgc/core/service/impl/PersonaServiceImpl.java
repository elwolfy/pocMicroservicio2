package com.lvl.poc.sgc.core.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lvl.poc.core.logger.CoreLogger;
import com.lvl.poc.core.logger.LoggerFactory;
import com.lvl.poc.core.service.ServiceBase;
import com.lvl.poc.domain.core.Persona;
import com.lvl.poc.model.core.PersonaFiltroRequest;
import com.lvl.poc.sgc.core.dao.PersonaRepository;
import com.lvl.poc.sgc.core.service.PersonaService;
import com.lvl.poc.util.GenericUtil;

@Service
@Transactional("transactionManager")
public class PersonaServiceImpl extends ServiceBase implements PersonaService {
	private CoreLogger logger = LoggerFactory.getLogger(PersonaServiceImpl.class);

	@Autowired
	private PersonaRepository personaDAO;

	@Override
	public List<Persona> find(PersonaFiltroRequest request) {
		try {
			return personaDAO.findAll();
		} catch (Exception e) {
			launchException(logger, e);
		}
		return null;
	}

	@Override
	public Persona get(BigDecimal personaId) {
		try {
			return personaDAO.getOne(personaId);
		} catch (Exception e) {
			launchException(logger, e);
		}
		return null;
	}

	@Override
	public void delete(Persona personaId) {
		try {
			Persona persona = personaDAO.getOne(personaId.getPersonaId());
			if (GenericUtil.isNotEmpty(persona)) {
				personaDAO.delete(persona);
			} else {

			}
		} catch (Exception e) {
			launchException(logger, e);
		}
	}

	@Override
	public void saveOrUpdate(Persona t) {
		try {
			// Persona persona = modelMapper.map(t, Persona.class);
			if (GenericUtil.isNotEmpty(t.getPersonaId()) && t.getPersonaId().intValue() > 0) {
				personaDAO.save(t);
			} else {
				// TODO campos de auditoria.
				personaDAO.save(t);
			}
		} catch (Exception e) {
			launchException(logger, e);
		}
	}

}
