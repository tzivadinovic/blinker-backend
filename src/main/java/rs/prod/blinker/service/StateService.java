package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface StateService {

	List<State> findAll();

	State save(State state);

	State update(State state);

	State findById(Integer stateId);

	void deleteById(Integer stateId);

}