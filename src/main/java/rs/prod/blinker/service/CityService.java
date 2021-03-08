package rs.prod.blinker.service;

import rs.prod.blinker.entity.City;

import java.util.List;

public interface CityService {

    List<City> findAll();

    City save(City city);

    City update(City city);

    City findById(Integer cityId);

    void deleteById(Integer cityId);

}