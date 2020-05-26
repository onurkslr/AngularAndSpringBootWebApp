package com.javacourse.project.hibernateAndJpa.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javacourse.project.hibernateAndJpa.Entities.*;
import com.javacourse.project.hibernateAndJpa.Business.ICityService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")					

public class CityController {
	private ICityService cityService;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	@CrossOrigin(origins ="http://localhost:4200/")
	@GetMapping("/cities")
	public List<City> get(){
		return cityService.GetAll();
	}
	@CrossOrigin(origins ="http://localhost:4200/add")
	@PostMapping("/add")
	public void add(@RequestBody City city) {
		cityService.add(city);
	}
	@CrossOrigin(origins ="http://localhost:4200/update")
	@PostMapping("/update")
	public void update(@RequestBody City city) {
		cityService.update(city);
	}
	@CrossOrigin(origins ="http://localhost:4200/delete")
	@PostMapping("/delete")
	public void delete(@RequestBody City city) {
		cityService.delete(city);
	}
	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id){
		return cityService.getById(id);
		
	}

}
