package com.boutiqueEnLigne.fngcine.repository;

import com.boutiqueEnLigne.fngcine.entity.Delivery;
import com.boutiqueEnLigne.fngcine.entity.EnumDelivery;
import com.boutiqueEnLigne.fngcine.entity.EnumRole;
import com.boutiqueEnLigne.fngcine.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
}
