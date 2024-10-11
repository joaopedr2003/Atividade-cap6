package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Lamp;

public interface LampRepository extends JpaRepository<Lamp, Long> {
}

