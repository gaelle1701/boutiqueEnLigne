package com.boutiqueEnLigne.fngcine.controller;

import com.boutiqueEnLigne.fngcine.entity.Delivery;
import com.boutiqueEnLigne.fngcine.service.DeliveryService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Getter
@Setter
@RequestMapping("api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("")
    public ResponseEntity<List<Delivery>> getDeliveries(){
        List<Delivery> deliveryList = deliveryService.getDeliveries();
        return ResponseEntity.ok(deliveryList);
    }

    @GetMapping("{deliveryId}")
    public ResponseEntity<Delivery> getDelivery(@PathVariable("deliveryId") Integer deliveryId) {
        Delivery delivery = deliveryService.getDelivery(deliveryId);
        return new ResponseEntity<>(delivery, HttpStatus.OK);

    }

}
