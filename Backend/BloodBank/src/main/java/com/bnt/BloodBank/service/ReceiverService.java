package com.bnt.BloodBank.service;

import java.util.List;
import com.bnt.BloodBank.model.Receiver;

public interface ReceiverService {
    Receiver saveReceiver(Receiver receiver);

    // Get all Receivers
    List<Receiver> getAllReceivers();

    // Get a Receiver by ID
    Receiver getReceiverById(Long id);

    // Update an existing Receiver by ID
    Receiver updateReceiver(Long id, Receiver receiver);

    boolean updateReceiverStatus(Long id, String status);

    // Delete a Receiver by ID
    boolean deleteReceiver(Long id);
}
