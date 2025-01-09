package com.bnt.BloodBank.service;


import com.bnt.BloodBank.model.Stock;
import com.bnt.BloodBank.repository.StockRepository;


import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }



    @PostConstruct
    public void init() {
        // Check if stock is empty, then insert predefined blood groups
        if (stockRepository.count() == 0) {
            stockRepository.save(new Stock("O+", 100));
            stockRepository.save(new Stock("O-", 100));
            stockRepository.save(new Stock("A+", 100));
            stockRepository.save(new Stock("A-", 100));
            stockRepository.save(new Stock("B+", 100));
            stockRepository.save(new Stock("B-", 100));
            stockRepository.save(new Stock("AB+", 100));
            stockRepository.save(new Stock("AB-", 100));

            System.out.println("Predefined blood groups and stock quantities have been inserted.");
        }
    }

    @Override
    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<Stock> getStockById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public Stock updateStock(Long id, Stock stock) {
        if (stockRepository.existsById(id)) {
            stock.setId(id);
            return stockRepository.save(stock);
        }
        return null; // Return null if stock not found for updating
    }

    public void updateStockByBloodGroup(String bloodGroup, int change) {
        Stock stock = stockRepository.findByBloodGroup(bloodGroup);
               

        stock.setUnits(stock.getUnits() + change);
        stockRepository.save(stock);
    }
    @Override
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }



    @Override
    public Stock updateStockUnits(String bloodGroup, int units) {
        Stock stock = stockRepository.findByBloodGroup(bloodGroup);
               

        stock.setUnits(stock.getUnits() + units);
        return stockRepository.save(stock);
    }
}

