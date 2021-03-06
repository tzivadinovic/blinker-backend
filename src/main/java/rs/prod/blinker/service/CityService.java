package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface CityService {

	List<City> findAll();

	City save(City city);

	City update(City city);

	City findById(Integer cityId);

	void deleteById(Integer cityId);

}