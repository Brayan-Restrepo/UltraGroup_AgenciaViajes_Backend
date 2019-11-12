package com.ultragroup.agenciaviaje.service;

import java.util.List;

import com.ultragroup.agenciaviaje.model.dto.FiltroHabitacionDto;
import com.ultragroup.agenciaviaje.model.dto.HabilitarDto;
import com.ultragroup.agenciaviaje.model.hotel.Hotel;
import com.ultragroup.agenciaviaje.model.hotel.Reserva;

public interface HotelService {
	
	public void saveHotel(Hotel hotel);
	public void updateHotel(Hotel hotel);
	public void habilitarHotel(HabilitarDto habilitarDto);
	public Hotel findById(String id);
	public List<Hotel> findAll();
	public List<Hotel> hotelFindFiltro(FiltroHabitacionDto filtroHabitacion);
}
