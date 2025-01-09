package com.bnt.BloodBank.repository;



import com.bnt.BloodBank.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock findByBloodGroup(String bloodGroup);
 
}

