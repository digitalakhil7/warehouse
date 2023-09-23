package com.av.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.av.model.ShipmentType;
import com.av.service.ShipmentTypeService;

@Controller
public class ShipmentTypeController {
	@Autowired
	private ShipmentTypeService service;
	
	@GetMapping("/register")
	public String showRegister() {
		return "home";
	}
	
	@PostMapping("/save")
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		Integer id = service.saveShipmentType(shipmentType);
		String msg = "Shipment saved with id: "+id;
		model.addAttribute("msg",msg);
		return "home";
	}
	
	@GetMapping("/getAll")
	public String getAllShipmentTypes(Model model) {
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "show";
	}
	
	@GetMapping("/getOne")
	public String getOneShipmentType(@RequestParam Integer id, Model model) {
		ShipmentType st = service.getOneShipmentType(id);
		model.addAttribute("st", st);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateOneShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		service.updateOneShipmentType(shipmentType);
		return "redirect:getAll";
	}
	
	@GetMapping("/deleteOne")
	public String deleteOneShipmentType(@RequestParam Integer id, Model model) {
		id = service.deleteOneShipmenetType(id);
		String msg = "Shipment deleted having id: "+id;
		model.addAttribute("msg",msg);
		
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "show";
	}
}
