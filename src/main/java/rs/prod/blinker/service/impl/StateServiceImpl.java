package rs.prod.blinker.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.State;
import rs.prod.blinker.repository.StateRepository;
import rs.prod.blinker.service.StateService;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class StateServiceImpl implements StateService {
	private final StateRepository stateRepository;

	@Override
	public List<State> findAll() {
		return stateRepository.findAll();
	}

	@Override
	public State findById(Integer stateId) {
		return stateRepository.findById(stateId)
				.orElseThrow(() -> new NoSuchElementException("StateService.notFound"));
	}

	@Override
	public State save(State state) {
		return stateRepository.save(state);
	}

	@Override
	public State update(State state) {
		return stateRepository.save(state);
	}

	@Override
	public void deleteById(Integer stateId) {
		stateRepository.deleteById(stateId);
	}


}