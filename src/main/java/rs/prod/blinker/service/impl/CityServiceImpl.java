package rs.prod.blinker.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.*;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.*;
import rs.prod.blinker.repository.CityRepository;
import rs.prod.blinker.service.CityService;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class CityServiceImpl implements CityService {
	private final CityRepository cityRepository;

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public City findById(Integer cityId) {
		return cityRepository.findById(cityId)
				.orElseThrow(() -> new NoSuchElementException("CityService.notFound"));
	}

	@Override
	public City save(City city) {
		return cityRepository.save(city);
	}

	@Override
	public City update(City city) {
		return cityRepository.save(city);
	}

	@Override
	public void deleteById(Integer cityId) {
		cityRepository.deleteById(cityId);
	}


}