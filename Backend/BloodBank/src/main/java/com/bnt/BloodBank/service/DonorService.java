package com.bnt.BloodBank.service;

import com.bnt.BloodBank.model.Donor;

import java.util.List;

public interface DonorService {

    Donor createDonor(Donor donor);

    Donor getDonorById(Long id);

    List<Donor> getAllDonors();

    Donor updateDonor(Long id, Donor updatedDonor);
    
    void deleteDonor(Long id);
}
