package com.boutiqueEnLigne.fngcine.repository;

import com.boutiqueEnLigne.fngcine.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
