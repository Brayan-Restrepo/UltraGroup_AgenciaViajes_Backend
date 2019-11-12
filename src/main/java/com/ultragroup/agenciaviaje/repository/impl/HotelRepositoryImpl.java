package com.ultragroup.agenciaviaje.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.ultragroup.agenciaviaje.model.dto.FiltroHabitacionDto;
import com.ultragroup.agenciaviaje.model.dto.HabilitarDto;
import com.ultragroup.agenciaviaje.model.hotel.Hotel;
import com.ultragroup.agenciaviaje.repository.HotelRepository;

@Repository
public class HotelRepositoryImpl implements HotelRepository {

	@Autowired
	private final MongoOperations mongoOperations;

	@SuppressWarnings("deprecation")
	public HotelRepositoryImpl(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations);
		this.mongoOperations = mongoOperations;
	}
		
	@Override
	public Hotel findById(String id) {
		return this.mongoOperations.findById(id, Hotel.class);
	}
	
	@Override
	public List<Hotel> findAll() {
		return this.mongoOperations.findAll(Hotel.class);
	}

	@Override
	public List<Hotel> findFiltro(FiltroHabitacionDto filtroHabitacion) {
		Query query = new Query();
		query.addCriteria(Criteria.where("activo").is(true));
		query.addCriteria(Criteria.where("ciudad").is(filtroHabitacion.getCiudad()));
		query.addCriteria(Criteria.where("habitaciones.cantidadPersona").is(filtroHabitacion.getCantidadPersona()));
		return this.mongoOperations.find(query, Hotel.class);
	}

	@Override
	public void save(Hotel hotel) {
		this.mongoOperations.save(hotel);
	}

	@Override
	public void updateHotel(Hotel hotel) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(hotel.getId()));
		Update update = new Update();
		update.set("activo", hotel.isActivo());
		update.set("ciudad", hotel.getCiudad());
		update.set("direccion", hotel.getDireccion());
		update.set("estrella", hotel.getEstrella());
		update.set("nombre", hotel.getNombre());
		this.mongoOperations.updateFirst(query, update, Hotel.class);
		
	}

	@Override
	public void deleteHotel(String id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void habilitarHotel(HabilitarDto habilitarDto) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(habilitarDto.getIdHotel()));
		Update update = new Update();
		update.set("activo", habilitarDto.isActivo());
		this.mongoOperations.updateFirst(query, update, Hotel.class);
	}

}
