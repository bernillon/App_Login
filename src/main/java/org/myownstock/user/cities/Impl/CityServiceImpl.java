package org.myownstock.user.cities.Impl;

import org.myownstock.user.cities.City;
import org.myownstock.user.cities.CityService;
import org.myownstock.user.cities.ICity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private ICity repository;

    @Override
    public City add(City city) {
        city = repository.save(city);

        return city;
    }
    @Override
    public ResponseEntity<?> update(City city){
        this.repository.save(city);
        return ResponseEntity.ok().build();
    }
    @Override
    public List<City> findAll() {
        return this.repository.findAll();
    }
}
