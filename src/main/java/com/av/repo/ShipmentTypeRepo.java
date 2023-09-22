package com.av.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.av.model.ShipmentType;

public interface ShipmentTypeRepo extends JpaRepository<ShipmentType, Integer> {

}
