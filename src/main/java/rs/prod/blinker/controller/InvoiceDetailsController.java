package rs.prod.blinker.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.InvoiceDetails;
import rs.prod.blinker.service.InvoiceDetailsService;

import java.util.List;

@RestController
@RequestMapping("/invoice-detailses")
@RequiredArgsConstructor
public class InvoiceDetailsController {
    private final InvoiceDetailsService invoiceDetailsService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllInvoiceDetailses")
    public ResponseEntity<List<InvoiceDetails>> getAllInvoiceDetailses() {
        return ResponseEntity.ok(invoiceDetailsService.findAll());
    }

    @GetMapping("/{invoiceDetailId}")
    @ApiOperation(value = "", nickname = "getInvoiceDetailsById")
    public ResponseEntity<InvoiceDetails> getInvoiceDetailsById(@PathVariable Integer invoiceDetailId) {
        return ResponseEntity.ok(invoiceDetailsService.findById(invoiceDetailId));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveInvoiceDetails")
    public ResponseEntity<InvoiceDetails> saveInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) {
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceDetailsService.save(invoiceDetails));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateInvoiceDetails")
    public ResponseEntity<InvoiceDetails> updateInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) {
        return ResponseEntity.ok(invoiceDetailsService.update(invoiceDetails));
    }

    @PutMapping("/{invoiceDetailId}/setItemsInfo")
    @ApiOperation(value = "", nickname = "setItemsInfo")
    public ResponseEntity<InvoiceDetails> setItemsInfo(@PathVariable Integer invoiceDetailId) {
        return ResponseEntity.ok(invoiceDetailsService.setTotalItems(invoiceDetailId));
    }

    @DeleteMapping("/{invoiceDetailId}")
    @ApiOperation(value = "", nickname = "deleteInvoiceDetailsById")
    public void deleteInvoiceDetailsById(@PathVariable Integer invoiceDetailId) {
        invoiceDetailsService.deleteById(invoiceDetailId);
    }

}

