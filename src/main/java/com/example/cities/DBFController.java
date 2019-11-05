package com.example.cities;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class DBFController {
	@Autowired
	private CitiesRepo repo;
	
	@GetMapping("/showall")
	public ArrayList<Cities> monkey(){
		return repo.findAll();
	}
	
	@GetMapping("/filterbycity/{N}")
	public ArrayList<Cities> strawberry(@PathVariable String N){
		return repo.findByCity(N);
	}
	
	@GetMapping("/filterbyregion/{R}")
	public ArrayList<Cities> pumpkin(@PathVariable String R){
		return repo.findByRegion(R);
	}
	
	@GetMapping("/showbypopulationgreaterthan/{p}")
	public ArrayList<Cities> findByPopulationGreaterThan(@PathVariable int p){
		return repo.findByPopulationGreaterThan(p);
	}
	
	@GetMapping("/findmaxpopulation")
	public int findmaxpopulation() {
		return repo.findmaxpopulation();
	}
	
	@GetMapping("/findbiggestcity")
	public String findbiggestcity() {
		return repo.findbiggestcity();
	}
		
//	@PostMapping("/save2/{city}/{population}/{region}")
//	public void Savedata(@PathVariable String city,
//						 @PathVariable int population,
//						 @PathVariable String region) {
//		Cities Ref = new Cities();
//		Ref.setCity(city);
//		Ref.setPopulation(population);
//		Ref.setRegion(region);
//		repo.save(Ref);
//	}
	
	@PostMapping("/saveData")
	public Cities saveData(@RequestBody Cities cities) {
		return repo.save(cities);
	}
	
	@DeleteMapping("/deletecity/{city}")
	public String deletecity(@PathVariable String city) {
		repo.deleteById(city);
		return "City successfully Deleted";
	}
	
	
	
//	@DeleteMapping("deletecity/{city}")
//    public String deletecity(@PathVariable String city) {
//        repo.deleteById(city);
//        return "City successfully Deleted";
//    }

}