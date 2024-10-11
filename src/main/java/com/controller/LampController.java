package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Lamp;
import com.service.LampService;

@RestController
@RequestMapping("/api/lamps")
public class LampController {

    @Autowired
    private LampService lampService;

    @GetMapping
    public List<Lamp> getAllLamps() {
        return lampService.findAllLamps();
    }

    @PostMapping
    public Lamp createLamp(@RequestBody Lamp lamp) {
        return lampService.saveLamp(lamp);
    }

    @PutMapping("/{id}")
    public Lamp updateLamp(@PathVariable Long id, @RequestBody Lamp updatedLamp) {
        return lampService.updateLamp(id, updatedLamp);
    }

    @DeleteMapping("/{id}")
    public void deleteLamp(@PathVariable Long id) {
        lampService.deleteLamp(id);
    }
}
