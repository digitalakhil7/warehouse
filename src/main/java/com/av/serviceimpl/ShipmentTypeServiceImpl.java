package com.av.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av.model.ShipmentType;
import com.av.repo.ShipmentTypeRepo;
import com.av.service.ShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl implements ShipmentTypeService {
	@Autowired ShipmentTypeRepo repo;

	@Override
	public Integer saveShipmentType(ShipmentType shipmentType) {
		shipmentType = repo.save(shipmentType);
		return shipmentType.getShipId();
	}
	@Override
	public List<ShipmentType> getAllShipmentTypes() {
		return repo.findAll();
	}
	
	@Override
	public Integer deleteOneShipmenetType(Integer id) {
		if(id!=null) {
			repo.deleteById(id);
		}
		return id;
	}
	
	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		Optional<ShipmentType> opt = repo.findById(id);
		ShipmentType st = null;
		if(opt.isPresent()) {
			st = opt.get();
		}
		return st;
	}
	
	@Override
	public void updateOneShipmentType(ShipmentType shipmentType) {
		repo.save(shipmentType);
		
	}
}
