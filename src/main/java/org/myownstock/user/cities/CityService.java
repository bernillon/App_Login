package org.myownstock.user.cities;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CityService {
    /**
     * Designated method to add a new city
     * @param City city
     * @return City
     */
    public City add(City city);

    /**
     *
     * @param City city
     * @return ResponseEntity<?>
     */
    public ResponseEntity<?> update(City city);

    /**
     *
     * Designated method to find all cities
     * @return List<City>
     */
    public List<City> findAll();

}
