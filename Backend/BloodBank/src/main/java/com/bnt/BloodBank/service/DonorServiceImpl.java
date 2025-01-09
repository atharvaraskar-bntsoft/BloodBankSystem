package com.bnt.BloodBank.service;


import com.bnt.BloodBank.model.Donor;
import com.bnt.BloodBank.repository.DonorRepository;
import com.bnt.BloodBank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorServiceImpl implements DonorService {

    private final DonorRepository donorRepository;

    @Autowired
    public DonorServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public Donor createDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    @Override
    public Donor getDonorById(Long id) {
        return donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor not found with ID: " + id));
    }

    @Override
    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    @Override
    public Donor updateDonor(Long id, Donor updatedDonor) {
        Donor existingDonor = getDonorById(id);
        existingDonor.setName(updatedDonor.getName());
        existingDonor.setMobile(updatedDonor.getMobile());
        existingDonor.setEmail(updatedDonor.getEmail());
        existingDonor.setBloodGroup(updatedDonor.getBloodGroup());
        existingDonor.setFatherName(updatedDonor.getFatherName());
        existingDonor.setMotherName(updatedDonor.getMotherName());
        existingDonor.setAddress(updatedDonor.getAddress());
        return donorRepository.save(existingDonor);
    }

    @Override
    public void deleteDonor(Long id) {
        donorRepository.deleteById(id);
    }
}

