package com.example.cities;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepo extends JpaRepository<Cities,String>{
	public ArrayList<Cities> findAll();
	public ArrayList<Cities> findByCity(String city);
	public ArrayList<Cities> findByRegion(String R);
	public ArrayList<Cities> findByPopulationGreaterThan(int p);
	public int findmaxpopulation();
	public String findbiggestcity();
	public void deleteById(String city);
	}