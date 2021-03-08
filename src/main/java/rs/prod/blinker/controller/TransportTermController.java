package rs.prod.blinker.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.TransportTerm;
import rs.prod.blinker.service.TransportTermService;

import java.util.List;

@RestController
@RequestMapping("/transport-terms")
@RequiredArgsConstructor
public class TransportTermController {
    private final TransportTermService transportTermService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllTransportTerms")
    public ResponseEntity<List<TransportTerm>> getAllTransportTerms() {
        return ResponseEntity.ok(transportTermService.findAll());
    }

    @GetMapping("/{transportTermId}")
    @ApiOperation(value = "", nickname = "getTransportTermById")
    public ResponseEntity<TransportTerm> getTransportTermById(@PathVariable Integer transportTermId) {
        return ResponseEntity.ok(transportTermService.findById(transportTermId));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveTransportTerm")
    public ResponseEntity<TransportTerm> saveTransportTerm(@RequestBody TransportTerm transportTerm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transportTermService.save(transportTerm));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateTransportTerm")
    public ResponseEntity<TransportTerm> updateTransportTerm(@RequestBody TransportTerm transportTerm) {
        return ResponseEntity.ok(transportTermService.update(transportTerm));
    }

    @DeleteMapping("/{transportTermId}")
    @ApiOperation(value = "", nickname = "deleteTransportTermById")
    public void deleteTransportTermById(@PathVariable Integer transportTermId) {
        transportTermService.deleteById(transportTermId);
    }

}

