package com.ultragroup.agenciaviaje.service;

import java.util.List;

import com.ultragroup.agenciaviaje.model.dto.FiltroHabitacionDto;
import com.ultragroup.agenciaviaje.model.hotel.Reserva;

public interface ReservaService {

	public void saveReserva(Reserva reserva);
	public List<Reserva> findAll();
	public List<Reserva> findFiltro(FiltroHabitacionDto filtroHabitacion);
}
