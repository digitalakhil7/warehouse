package com.av.serviceimpl;

import java.util.List;

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
}
