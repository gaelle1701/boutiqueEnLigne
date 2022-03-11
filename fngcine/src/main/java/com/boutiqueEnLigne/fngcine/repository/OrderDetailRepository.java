package com.boutiqueEnLigne.fngcine.repository;

import com.boutiqueEnLigne.fngcine.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
}
