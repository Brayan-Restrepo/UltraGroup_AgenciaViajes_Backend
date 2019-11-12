package com.ultragroup.agenciaviaje.repository;

import java.util.List;

import com.ultragroup.agenciaviaje.model.dto.FiltroHabitacionDto;
import com.ultragroup.agenciaviaje.model.hotel.Reserva;

public interface ReservaRepository {

	public void save(Reserva reserva);
	public List<Reserva> findAll();
	public List<String> findFiltroByIdHabitacion(FiltroHabitacionDto filtroHabitacion, List<String> idHabitacion);
}
