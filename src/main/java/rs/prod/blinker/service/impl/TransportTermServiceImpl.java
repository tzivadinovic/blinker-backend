package rs.prod.blinker.service.impl;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.prod.blinker.entity.TransportTerm;
import rs.prod.blinker.repository.TransportTermRepository;
import rs.prod.blinker.service.TransportTermService;

import java.util.List;
import java.util.NoSuchElementException;

@Data
@Service
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class TransportTermServiceImpl implements TransportTermService {
	private final TransportTermRepository transportTermRepository;

	@Override
	public List<TransportTerm> findAll() {
		return transportTermRepository.findAll();
	}

	@Override
	public TransportTerm findById(Integer transportTermId) {
		return transportTermRepository.findById(transportTermId)
				.orElseThrow(() -> new NoSuchElementException("TransportTermService.notFound"));
	}

	@Override
	public TransportTerm save(TransportTerm transportTerm) {
		return transportTermRepository.save(transportTerm);
	}

	@Override
	public TransportTerm update(TransportTerm transportTerm) {
		return transportTermRepository.save(transportTerm);
	}

	@Override
	public void deleteById(Integer transportTermId) {
		transportTermRepository.deleteById(transportTermId);
	}


}