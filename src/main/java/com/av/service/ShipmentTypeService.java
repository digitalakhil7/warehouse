package com.av.service;

import java.util.List;

import com.av.model.ShipmentType;

public interface ShipmentTypeService {
	Integer saveShipmentType(ShipmentType shipmentType);
	List<ShipmentType> getAllShipmentTypes();
	Integer deleteOneShipmenetType(Integer id);
	ShipmentType getOneShipmentType(Integer id);
	void updateOneShipmentType(ShipmentType shipmentType);
}
