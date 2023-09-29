package com.av.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.av.exception.ShipmentTypeNotFoundException;
import com.av.model.ShipmentType;
import com.av.service.ShipmentTypeService;

@Controller
public class ShipmentTypeController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShipmentTypeController.class);
	
	@Autowired
	private ShipmentTypeService service;
	
	@GetMapping("/register")
	public String showRegister() {
		return "home";
	}
	
	@PostMapping("/save")
	public String saveShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		logger.info("entered into save method");
		try {
			Integer id = service.saveShipmentType(shipmentType);
			logger.debug("shipment created with id {}", id);
			String msg = "Shipment saved with id: "+id;
			model.addAttribute("msg",msg);
		}
		catch(Exception e) {
			logger.error("save has exception due to {}", e.getMessage());
			e.printStackTrace();
		}
		logger.info("returning home page");
		return "home";
	}
	
	@GetMapping("/getAll")
	public String getAllShipmentTypes(Model model) {
		logger.info("getting all shipments");
		List<ShipmentType> list = service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "show";
	}
	
	@GetMapping("/getOne")
	public String getOneShipmentType(@RequestParam Integer id, Model model) {
		String page = "";
		try {
			ShipmentType st = service.getOneShipmentType(id);
			model.addAttribute("st", st);
			page = "edit";
		}
		catch(ShipmentTypeNotFoundException e) {
			List<ShipmentType> list = service.getAllShipmentTypes();
			model.addAttribute("list",list);
			model.addAttribute("msg", e.getMessage());
			page = "show";
		}
		return page;
	}
	
	@PostMapping("/update")
	public String updateOneShipmentType(@ModelAttribute ShipmentType shipmentType, Model model) {
		service.updateOneShipmentType(shipmentType);
		return "redirect:getAll";
	}
	
	@GetMapping("/deleteOne")
	public String deleteOneShipmentType(@RequestParam Integer id, Model model) {
		try {
			id = service.deleteOneShipmenetType(id);
			String msg = "Shipment deleted having id: "+id;
			model.addAttribute("msg",msg);
			
			List<ShipmentType> list = service.getAllShipmentTypes();
			model.addAttribute("list",list);
		}
		catch(ShipmentTypeNotFoundException e) {
			List<ShipmentType> list = service.getAllShipmentTypes();
			model.addAttribute("list",list);
			model.addAttribute("msg", e.getMessage());
		}
		return "show";
	}
	
	@GetMapping("/error")
	public String errorPage(Model model) {
		model.addAttribute("msg", "OOPS Page");
		return "error";
	}
}
