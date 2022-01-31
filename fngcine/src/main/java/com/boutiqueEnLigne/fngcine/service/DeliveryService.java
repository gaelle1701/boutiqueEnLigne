package com.boutiqueEnLigne.fngcine.service;

import com.boutiqueEnLigne.fngcine.entity.Delivery;

import java.util.List;

public interface DeliveryService {
    Delivery getDelivery(Integer id);
    List<Delivery> getDeliveries();
}
