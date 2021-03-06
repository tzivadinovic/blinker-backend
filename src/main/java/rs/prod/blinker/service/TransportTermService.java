package rs.prod.blinker.service;

import java.util.Collection;
import java.util.List;
import rs.prod.blinker.entity.*;

public interface TransportTermService {

	List<TransportTerm> findAll();

	TransportTerm save(TransportTerm transportTerm);

	TransportTerm update(TransportTerm transportTerm);

	TransportTerm findById(Integer transportTermId);

	void deleteById(Integer transportTermId);

}