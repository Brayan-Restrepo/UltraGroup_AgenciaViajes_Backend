package com.ultragroup.agenciaviaje.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.ultragroup.agenciaviaje.model.dto.FiltroHabitacionDto;
import com.ultragroup.agenciaviaje.model.hotel.Reserva;
import com.ultragroup.agenciaviaje.repository.ReservaRepository;

@Repository
public class ReservaRepositiryImpl implements ReservaRepository {

	@Autowired
	private final MongoOperations mongoOperations;

	@SuppressWarnings("deprecation")
	public ReservaRepositiryImpl(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations);
		this.mongoOperations = mongoOperations;
	}
	
	@Override
	public void save(Reserva reserva) {
		this.mongoOperations.save(reserva);
	}

	@Override
	public List<Reserva> findAll() {
		return this.mongoOperations.findAll(Reserva.class);
	}

	@Override
	public List<String> findFiltroByIdHabitacion(FiltroHabitacionDto filtroHabitacion, List<String> idHabitacion) {
		Query query = new Query();
		query.addCriteria(Criteria.where("habitacionId").in(idHabitacion));
		
		query.addCriteria(Criteria.where("fechaEntrada").exists(true).andOperator(		
			Criteria.where("fechaEntrada").exists(true).orOperator(
						Criteria.where("fechaEntrada").lte(filtroHabitacion.getFechaEntrada()),
						Criteria.where("fechaEntrada").lte(filtroHabitacion.getFechaSalida())				
					),			
			Criteria.where("fechaSalida").exists(true).orOperator(
						Criteria.where("fechaSalida").gte(filtroHabitacion.getFechaEntrada()),
						Criteria.where("fechaSalida").gte(filtroHabitacion.getFechaSalida())				
					)
		));
		
		return this.mongoOperations.findDistinct(query, "habitacionId", Reserva.class, String.class);
	}

}
