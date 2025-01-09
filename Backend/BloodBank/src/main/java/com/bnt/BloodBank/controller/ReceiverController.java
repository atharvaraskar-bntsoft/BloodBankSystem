package com.bnt.BloodBank.controller;

import com.bnt.BloodBank.model.Receiver;
import com.bnt.BloodBank.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/receivers") 
public class ReceiverController {

    @Autowired
    private ReceiverService receiverService;

    // Create a new Receiver
    @PostMapping
    public ResponseEntity<Receiver> createReceiver(@RequestBody Receiver receiver) {
        Receiver savedReceiver = receiverService.saveReceiver(receiver);
        return new ResponseEntity<>(savedReceiver, HttpStatus.CREATED);
    }

    // Get all Receivers
    @GetMapping
    public ResponseEntity<List<Receiver>> getAllReceivers() {
        List<Receiver> receivers = receiverService.getAllReceivers();
        return new ResponseEntity<>(receivers, HttpStatus.OK);
    }

    // Get Receiver by ID
    @GetMapping("/{id}")
    public ResponseEntity<Receiver> getReceiverById(@PathVariable Long id) {
        Receiver receiver = receiverService.getReceiverById(id);
        if (receiver != null) {
            return new ResponseEntity<>(receiver, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update Receiver by ID
    @PutMapping("/{id}")
    public ResponseEntity<Receiver> updateReceiver(@PathVariable Long id, @RequestBody Receiver receiver) {
        Receiver updatedReceiver = receiverService.updateReceiver(id, receiver);
        if (updatedReceiver != null) {
            return new ResponseEntity<>(updatedReceiver, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateReceiverStatus(@PathVariable Long id, @RequestBody Map<String, String> requestBody) {
    String status = requestBody.get("status");
    boolean isUpdated = receiverService.updateReceiverStatus(id, status);
    if (isUpdated) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}


    // Delete Receiver by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceiver(@PathVariable Long id) {
        boolean isDeleted = receiverService.deleteReceiver(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    
}
