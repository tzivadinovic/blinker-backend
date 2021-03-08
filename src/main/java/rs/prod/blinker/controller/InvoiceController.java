package rs.prod.blinker.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.Invoice;
import rs.prod.blinker.service.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllInvoices")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(invoiceService.findAll());
    }

    @GetMapping("/{invoiceId}")
    @ApiOperation(value = "", nickname = "getInvoiceById")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Integer invoiceId) {
        return ResponseEntity.ok(invoiceService.findById(invoiceId));
    }

    @GetMapping("/lastCreated")
    @ApiOperation(value = "", nickname = "lastCreated")
    public ResponseEntity<Invoice> findLastCreated() {
        return ResponseEntity.ok(invoiceService.findLastCreated());
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveInvoice")
    public ResponseEntity<Invoice> saveInvoice() {
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.save());
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateInvoice")
    public ResponseEntity<Invoice> updateInvoice(@RequestBody Invoice invoice) {
        return ResponseEntity.ok(invoiceService.update(invoice));
    }

    @DeleteMapping("/{invoiceId}")
    @ApiOperation(value = "", nickname = "deleteInvoiceById")
    public void deleteInvoiceById(@PathVariable Integer invoiceId) {
        invoiceService.deleteById(invoiceId);
    }

}

