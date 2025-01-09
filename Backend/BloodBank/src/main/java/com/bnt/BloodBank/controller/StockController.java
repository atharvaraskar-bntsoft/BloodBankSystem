package com.bnt.BloodBank.controller;


import com.bnt.BloodBank.model.Stock;
import com.bnt.BloodBank.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        Stock savedStock = stockService.addStock(stock);
        return new ResponseEntity<>(savedStock, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Optional<Stock> stock = stockService.getStockById(id);
        return stock.map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stock) {
        Stock updatedStock = stockService.updateStock(id, stock);
        return updatedStock != null ? new ResponseEntity<>(updatedStock, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{bloodGroup}")
    public ResponseEntity<String> updateStockByBloodGroup( @PathVariable String bloodGroup,@RequestBody Map<String, Integer> requestBody) {
    int change = requestBody.get("units");
    stockService.updateStockUnits(bloodGroup, change);
    return ResponseEntity.ok("Stock updated successfully");
}


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
