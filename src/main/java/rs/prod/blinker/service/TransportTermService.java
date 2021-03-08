package rs.prod.blinker.service;

import rs.prod.blinker.entity.TransportTerm;

import java.util.List;

public interface TransportTermService {

    List<TransportTerm> findAll();

    TransportTerm save(TransportTerm transportTerm);

    TransportTerm update(TransportTerm transportTerm);

    TransportTerm findById(Integer transportTermId);

    void deleteById(Integer transportTermId);

}