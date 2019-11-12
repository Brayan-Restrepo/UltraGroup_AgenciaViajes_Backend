package com.ultragroup.agenciaviaje.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ultragroup.agenciaviaje.exception.NotFoundException;
import com.ultragroup.agenciaviaje.model.hotel.Reserva;
import com.ultragroup.agenciaviaje.service.ReservaService;

@RestController
@RequestMapping("reserva")
public class ReservaController {

	private static final Log log = LogFactory.getLog(ReservaController.class);

	@Autowired
	private ReservaService reservaService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Reserva>> findAll() throws NotFoundException {
		log.info("Get Reserva findAll");
		return ResponseEntity.ok(this.reservaService.findAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Reserva reserva) throws NotFoundException {
		log.info("Get Reserva findAll");
		this.reservaService.saveReserva(reserva);
		return ResponseEntity.noContent().build();
	}
}
