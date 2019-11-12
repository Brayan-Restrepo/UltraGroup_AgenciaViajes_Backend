package com.ultragroup.agenciaviaje.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ultragroup.agenciaviaje.exception.NotFoundException;
import com.ultragroup.agenciaviaje.model.dto.FiltroHabitacionDto;
import com.ultragroup.agenciaviaje.model.dto.HabilitarDto;
import com.ultragroup.agenciaviaje.model.hotel.Hotel;
import com.ultragroup.agenciaviaje.service.HotelService;

@CrossOrigin("*")
@RestController
@RequestMapping("hotel")
public class HotelController {

	private static final Log log = LogFactory.getLog(HotelController.class);

	@Autowired
	private HotelService hotelService;
	
	/**
	 * Listar todos los hoteles
	 * @param userId
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Hotel>> hotelFindAll() throws NotFoundException {
		log.info("Get hotelFindAll");
		return ResponseEntity.ok(this.hotelService.findAll());
	}
	
	/**
	 * 
	 * @param filtroHabitacion
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ResponseEntity<List<Hotel>> hotelFindFiltro(@RequestBody FiltroHabitacionDto filtroHabitacion) throws NotFoundException {
		log.info("Post hotelFindFiltro");
		return ResponseEntity.ok(this.hotelService.hotelFindFiltro(filtroHabitacion));
	}

	/**
	 * 
	 * @param hotel
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Hotel> hotelSave(@RequestBody Hotel hotel) throws NotFoundException {
		log.info("Post hotelSave");
		this.hotelService.saveHotel(hotel);		
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> hotelUpdate(@RequestBody Hotel hotel) throws NotFoundException {
		log.info("Put hotelUpdate");
		this.hotelService.updateHotel(hotel);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * Habilitar Hotel
	 * @param habilitarDto
	 * @return
	 * @throws NotFoundException
	 */
	@RequestMapping(value = "/habilitar", method = RequestMethod.POST)
	public ResponseEntity<Void> hotelHabilitar(@RequestBody HabilitarDto habilitarDto) throws NotFoundException {
		log.info("Post hotelHabilitar");
		this.hotelService.habilitarHotel(habilitarDto);
		return ResponseEntity.noContent().build();
	}
}
