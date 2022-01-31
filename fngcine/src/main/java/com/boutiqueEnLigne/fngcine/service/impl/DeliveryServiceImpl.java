package com.boutiqueEnLigne.fngcine.service.impl;

import com.boutiqueEnLigne.fngcine.entity.Delivery;
import com.boutiqueEnLigne.fngcine.repository.DeliveryRepository;
import com.boutiqueEnLigne.fngcine.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public Delivery getDelivery(Integer id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        System.out.println(delivery);
        if(delivery.isPresent()){
            return delivery.get();
        }
        return null;
    }

    @Override
    public List<Delivery> getDeliveries() {
        return deliveryRepository.findAll();
    }
}
