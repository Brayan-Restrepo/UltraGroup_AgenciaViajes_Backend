package com.ultragroup.agenciaviaje.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ultragroup.agenciaviaje.model.dto.FiltroHabitacionDto;
import com.ultragroup.agenciaviaje.model.hotel.Reserva;
import com.ultragroup.agenciaviaje.repository.ReservaRepository;
import com.ultragroup.agenciaviaje.service.ReservaService;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Override
	public void saveReserva(Reserva reserva) {
		this.reservaRepository.save(reserva);
	}

	@Override
	public List<Reserva> findAll() {
		return this.reservaRepository.findAll();
	}

	@Override
	public List<Reserva> findFiltro(FiltroHabitacionDto filtroHabitacion) {
		return this.findFiltro(filtroHabitacion);
	}

}
