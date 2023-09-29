package com.av.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.av.exception.ShipmentTypeNotFoundException;
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
		repo.delete(getOneShipmentType(id));
		return id;
	}

	/* Before Java 8
	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		Optional<ShipmentType> opt = repo.findById(id);
		if(opt.isEmpty()) {
			throw new ShipmentTypeNotFoundException("Shipment Not found");
		}
		else {
			return opt.get();
		}
	}
	*/
	@Override
	public ShipmentType getOneShipmentType(Integer id) {
		return repo.findById(id).orElseThrow(()-> new ShipmentTypeNotFoundException("ShipmentType: "+id+"  Not found Custom Exception"));
	}
	
	@Override
	public void updateOneShipmentType(ShipmentType shipmentType) {
		repo.save(shipmentType);
		
	}
}
