package com.venky.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venky.entity.City;

public interface CityRepository extends JpaRepository<City,Serializable> {

	List<City> findCities(Integer sId);
}
