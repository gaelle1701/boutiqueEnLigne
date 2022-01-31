package com.boutiqueEnLigne.fngcine.repository;

import com.boutiqueEnLigne.fngcine.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    Optional<Delivery> findById(Integer id);
}
