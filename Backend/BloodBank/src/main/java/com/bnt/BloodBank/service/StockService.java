package com.bnt.BloodBank.service;


import com.bnt.BloodBank.model.Stock;
import java.util.List;
import java.util.Optional;

public interface StockService {
    
    Stock addStock(Stock stock);

    List<Stock> getAllStocks();

    Optional<Stock> getStockById(Long id);

    Stock updateStock(Long id, Stock stock);

    Stock updateStockUnits(String bloodGroup, int units);
    
    void deleteStock(Long id);
}

