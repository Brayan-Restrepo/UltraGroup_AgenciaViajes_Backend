package com.ultragroup.agenciaviaje.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultragroup.agenciaviaje.model.dto.FiltroHabitacionDto;
import com.ultragroup.agenciaviaje.model.dto.HabilitarDto;
import com.ultragroup.agenciaviaje.model.hotel.Habitacion;
import com.ultragroup.agenciaviaje.model.hotel.Hotel;
import com.ultragroup.agenciaviaje.repository.HotelRepository;
import com.ultragroup.agenciaviaje.repository.ReservaRepository;
import com.ultragroup.agenciaviaje.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	private static final Log log = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public void saveHotel(Hotel hotel) {
        log.debug("saveHotel");
		this.hotelRepository.save(hotel);
	}

	@Override
	public void updateHotel(Hotel hotel) {
        log.debug("updateHotel");
		this.hotelRepository.updateHotel(hotel);
	}	

	@Override
	public void habilitarHotel(HabilitarDto habilitarDto) {
        log.debug("saveHotel");
		this.hotelRepository.habilitarHotel(habilitarDto);
	}

	@Override
	public Hotel findById(String id) {		
		return this.hotelRepository.findById(id);
	}

	@Override
	public List<Hotel> findAll() {
		return this.hotelRepository.findAll();
	}

	@Override
	public List<Hotel> hotelFindFiltro(FiltroHabitacionDto filtroHabitacion) {
		
		List<Hotel> hoteles =  this.hotelRepository.findFiltro(filtroHabitacion).stream().filter(element -> {			
				element.setHabitaciones(this.filterHabitacionPersona(element.getHabitaciones(), filtroHabitacion.getCantidadPersona()));
				return filtroHabitacion.getCiudad().equals(element.getCiudad());	
			}).collect(Collectors.toList());
		 
		return this.filtraFechaReserva(hoteles, filtroHabitacion);
	}
	
	/**
	 * Filtra los hoteles por las fechas que esten libres para reservar una habitacion
	 * @param hoteles
	 * @param filtroHabitacion
	 * @return
	 */
	private List<Hotel> filtraFechaReserva(List<Hotel> hoteles, FiltroHabitacionDto filtroHabitacion) {
		
		List<String> idHabitacionesReservas = this.reservaRepository.findFiltroByIdHabitacion(filtroHabitacion, this.idHabitacionList(hoteles));
		return hoteles.stream().map(hotel -> {
			hotel.setHabitaciones(hotel.getHabitaciones().stream().filter(hab -> !idHabitacionesReservas.contains(hab.getId())).collect(Collectors.toList()));
			return hotel;
		}).collect(Collectors.toList());		
	}
	
	/**
	 * Buscar los id de las habitaciones
	 * @param hoteles
	 * @return
	 */
	private List<String> idHabitacionList(List<Hotel> hoteles) {
		List<String> idHabitaciones = new ArrayList<String>();
		hoteles.stream().forEach(mapper -> {
			idHabitaciones.addAll(mapper.getHabitaciones().stream().map(id -> id.getId()).collect(Collectors.toList()));
		});
		return idHabitaciones;
	}
	
	/**
	 * Filtra las habitaciones por cantidad de personas
	 * @param habitaciones
	 * @param cantidadPersona
	 * @return
	 */
	private List<Habitacion> filterHabitacionPersona(List<Habitacion> habitaciones, String cantidadPersona) {
		return habitaciones.stream().filter(h -> h.getCantidadPersona().equals(cantidadPersona)).collect(Collectors.toList());
	}
	
}
