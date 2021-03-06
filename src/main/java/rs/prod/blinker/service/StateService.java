package rs.prod.blinker.service;

import rs.prod.blinker.entity.State;

import java.util.List;

public interface StateService {

	List<State> findAll();

	State save(State state);

	State update(State state);

	State findById(Integer stateId);

	void deleteById(Integer stateId);

}