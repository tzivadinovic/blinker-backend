package rs.prod.blinker.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.prod.blinker.entity.ProductInvoice;
import rs.prod.blinker.service.ProductInvoiceService;

import java.util.List;

@RestController
@RequestMapping("/product-invoices")
@RequiredArgsConstructor
public class ProductInvoiceController {
    private final ProductInvoiceService productInvoiceService;

    @GetMapping
    @ApiOperation(value = "", nickname = "getAllProductInvoices")
    public ResponseEntity<List<ProductInvoice>> getAllProductInvoices() {
        return ResponseEntity.ok(productInvoiceService.findAll());
    }

    @GetMapping("/{productInvoiceId}")
    @ApiOperation(value = "", nickname = "getProductInvoiceById")
    public ResponseEntity<ProductInvoice> getProductInvoiceById(@PathVariable Integer productInvoiceId) {
        return ResponseEntity.ok(productInvoiceService.findById(productInvoiceId));
    }

    @PostMapping
    @ApiOperation(value = "", nickname = "saveProductInvoice")
    public ResponseEntity<ProductInvoice> saveProductInvoice(@RequestBody ProductInvoice productInvoice) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productInvoiceService.save(productInvoice));
    }

    @PutMapping
    @ApiOperation(value = "", nickname = "updateProductInvoice")
    public ResponseEntity<ProductInvoice> updateProductInvoice(@RequestBody ProductInvoice productInvoice) {
        return ResponseEntity.ok(productInvoiceService.update(productInvoice));
    }

    @DeleteMapping("/{productInvoiceId}")
    @ApiOperation(value = "", nickname = "deleteProductInvoiceById")
    public void deleteProductInvoiceById(@PathVariable Integer productInvoiceId) {
        productInvoiceService.deleteById(productInvoiceId);
    }

    @GetMapping("/invoice/{invoiceId}")
    @ApiOperation(value = "", nickname = "findByInvoiceId")
    public ResponseEntity<List<ProductInvoice>> findByInvoiceId(@PathVariable Integer invoiceId) {
        return ResponseEntity.ok(productInvoiceService.findByInvoiceId(invoiceId));
    }

    @GetMapping("/invoice/totalValue/{invoiceId}")
    @ApiOperation(value = "", nickname = "totalValue")
    public ResponseEntity<Double> getInvoiceTotalValue(@PathVariable Integer invoiceId) {
        return ResponseEntity.ok(productInvoiceService.getInvoiceTotalValue(invoiceId));
    }

}

