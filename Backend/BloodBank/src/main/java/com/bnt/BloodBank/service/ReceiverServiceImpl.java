package com.bnt.BloodBank.service;

import com.bnt.BloodBank.model.Receiver;
import com.bnt.BloodBank.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceiverServiceImpl implements ReceiverService {

    @Autowired
    private ReceiverRepository receiverRepository;

    // Save Receiver
    public Receiver saveReceiver(Receiver receiver) {
        return receiverRepository.save(receiver);
    }

    // Get all Receivers
    public List<Receiver> getAllReceivers() {
        return receiverRepository.findAll();
    }

    // Get Receiver by ID
    public Receiver getReceiverById(Long id) {
        Optional<Receiver> receiver = receiverRepository.findById(id);
        return receiver.orElse(null);
    }

    // Update Receiver by ID
    public Receiver updateReceiver(Long id, Receiver receiver) {
        Optional<Receiver> existingReceiver = receiverRepository.findById(id);
        if (existingReceiver.isPresent()) {
            Receiver updatedReceiver = existingReceiver.get();
            updatedReceiver.setName(receiver.getName());
            updatedReceiver.setMobile(receiver.getMobile());
            updatedReceiver.setEmail(receiver.getEmail());
            updatedReceiver.setBloodGroup(receiver.getBloodGroup());
            return receiverRepository.save(updatedReceiver);
        }
        return null;
    }

    @Override
    public boolean updateReceiverStatus(Long id, String status) {
        Optional<Receiver> existingReceiver = receiverRepository.findById(id);
        if (existingReceiver.isPresent()) {
            Receiver receiver = existingReceiver.get();
            receiver.setStatus(status); // Assuming `status` is a field in the `Receiver` model
            receiverRepository.save(receiver);
            return true;
        }
        return false;
    }

    // Delete Receiver by ID
    public boolean deleteReceiver(Long id) {
        Optional<Receiver> receiver = receiverRepository.findById(id);
        if (receiver.isPresent()) {
            receiverRepository.delete(receiver.get());
            return true;
        }
        return false;
    }
}
