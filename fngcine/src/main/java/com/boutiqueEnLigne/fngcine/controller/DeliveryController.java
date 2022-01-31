package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Delivery;
import com.boutiqueEnLigne.fngcine.service.DeliveryService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@Setter
@RequestMapping("api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    ResponseEntity responseEntity;

    @GetMapping("")
    public ResponseEntity<List<Delivery>> getDeliveries() {
        List<Delivery> deliveries;
        deliveries = deliveryService.getDeliveries();

        return ResponseEntity.ok(deliveries);
    }

    @GetMapping("/{id}")
    public Delivery getDelivery(@PathVariable("id") Integer id) {
        return deliveryService.getDelivery(id);
    }
}
