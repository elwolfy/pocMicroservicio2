package com.lvl.poc.sgc.core.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvl.poc.model.BaseOperacionResponse;
import com.lvl.poc.model.CollectionResponse;
import com.lvl.poc.model.core.PersonaFiltroRequest;
import com.lvl.poc.model.core.PersonaRequest;
import com.lvl.poc.model.core.PersonaResponse;
import com.lvl.poc.sgc.core.facade.PersonaFacade;

@RestController
@RequestMapping("/api/persona")
public class PersonaRestController {

	@Autowired
	private PersonaFacade personaFacade;

	@PostMapping("/find")
	public CollectionResponse<PersonaResponse> find(@RequestBody PersonaFiltroRequest request) {
		return personaFacade.find(request);
	}

	@GetMapping("/initForm")
	public PersonaResponse initForm() {
		return personaFacade.initForm();
	}

	@PutMapping("/saveOrUpdate")
	public BaseOperacionResponse saveOrUpdate(@RequestBody PersonaRequest request) {
		return personaFacade.saveOrUpdate(request);
	}

	@DeleteMapping("/delete/{personaId}")
	public BaseOperacionResponse delete(@PathVariable BigDecimal personaId) {
		return personaFacade.delete(personaId);
	}

	@GetMapping("get/{personaId}")
	public PersonaResponse get(@PathVariable BigDecimal personaId) {
		return personaFacade.get(personaId);
	}
}