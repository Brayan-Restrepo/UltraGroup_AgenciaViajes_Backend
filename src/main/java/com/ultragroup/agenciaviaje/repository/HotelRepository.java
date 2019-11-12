package com.ultragroup.agenciaviaje.repository;

import java.util.List;

import com.ultragroup.agenciaviaje.model.dto.FiltroHabitacionDto;
import com.ultragroup.agenciaviaje.model.dto.HabilitarDto;
import com.ultragroup.agenciaviaje.model.hotel.Hotel;

public interface HotelRepository {

	public Hotel findById(String id);
	public List<Hotel> findAll();
	public List<Hotel> findFiltro(FiltroHabitacionDto filtroHabitacion);
	public void save(Hotel hotel);
	public void updateHotel(Hotel hotel);
	public void deleteHotel(String id);
	public void habilitarHotel(HabilitarDto habilitarDto);
}
