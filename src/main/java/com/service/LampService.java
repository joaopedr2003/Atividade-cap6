package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Lamp;
import com.repository.LampRepository;

@Service
public class LampService {

    @Autowired
    private LampRepository lampRepository;

    public List<Lamp> findAllLamps() {
        return lampRepository.findAll();
    }

    public Lamp saveLamp(Lamp lamp) {
        return lampRepository.save(lamp);
    }

    public Lamp updateLamp(Long id, Lamp updatedLamp) {
        return lampRepository.findById(id).map(lamp -> {
            lamp.setStatus(updatedLamp.isStatus());
            lamp.setLuminosity(updatedLamp.getLuminosity());
            return lampRepository.save(lamp);
        }).orElseThrow(() -> new RuntimeException("Lamp not found"));
    }

    public void deleteLamp(Long id) {
        lampRepository.deleteById(id);
    }
}
