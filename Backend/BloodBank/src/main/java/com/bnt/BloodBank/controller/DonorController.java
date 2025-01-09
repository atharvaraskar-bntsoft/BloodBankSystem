package com.bnt.BloodBank.controller;

import com.bnt.BloodBank.model.Donor;
import com.bnt.BloodBank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donor")
public class DonorController {

    private final DonorService donorService;

    @Autowired
    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @PostMapping
    public ResponseEntity<Donor> createDonor(@RequestBody Donor donor) {
        Donor createdDonor = donorService.createDonor(donor);
        return ResponseEntity.ok(createdDonor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Donor> getDonorById(@PathVariable Long id) {
        Donor donor = donorService.getDonorById(id);
        return ResponseEntity.ok(donor);
    }

    @GetMapping
    public ResponseEntity<List<Donor>> getAllDonors() {
        List<Donor> donors = donorService.getAllDonors();
        return ResponseEntity.ok(donors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Donor> updateDonor(@PathVariable Long id, @RequestBody Donor updatedDonor) {
        Donor donor = donorService.updateDonor(id, updatedDonor);
        return ResponseEntity.ok(donor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return ResponseEntity.noContent().build();
    }
}

